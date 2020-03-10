package site.okliu.newvision.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.okliu.newvision.dto.CommentDTO;
import site.okliu.newvision.dto.QuestionDTO;
import site.okliu.newvision.enums.CommentTypeEnum;
import site.okliu.newvision.enums.NotificationStatusEnum;
import site.okliu.newvision.enums.NotificationTypeEnum;
import site.okliu.newvision.exception.CustomizeErrorCode;
import site.okliu.newvision.exception.CustomizeException;
import site.okliu.newvision.mapper.CommentExtMapper;
import site.okliu.newvision.mapper.CommentMapper;
import site.okliu.newvision.model.Comment;
import site.okliu.newvision.model.Notification;
import site.okliu.newvision.model.User;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private CommentMapper commentMapper;
    private CommentExtMapper commentExtMapper;
    private UserService userService;
    private QuestionService questionService;
    private NotificationService notificationService;

    @Autowired
    public CommentService(CommentMapper commentMapper, CommentExtMapper commentExtMapper, UserService userService, QuestionService questionService, NotificationService notificationService) {
        this.commentMapper = commentMapper;
        this.commentExtMapper = commentExtMapper;
        this.userService = userService;
        this.questionService = questionService;
        this.notificationService = notificationService;
    }

    @Transactional
    public void insert(Comment comment, User commentator) {
        if (comment.getType() == CommentTypeEnum.QUESTION.getType()) {
            // 回复问题
            QuestionDTO questionDTO = questionService.findById(comment.getParentId());
            if (questionDTO == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);
            questionService.incCommentCount(comment.getParentId());
            // 通知问题
            createNotify(comment, questionDTO.getCreator(), commentator.getName(), questionDTO.getTitle(), NotificationTypeEnum.REPLY_QUESTION, comment.getParentId());
        } else {
            // 回复评论
            Optional<Comment> optionalComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (optionalComment.isPresent()) {
                Comment dbComment = optionalComment.get();
                commentMapper.insert(comment);
                commentExtMapper.incCommentCount(dbComment.getId());
                QuestionDTO questionDTO = questionService.findById(dbComment.getParentId());
                if (questionDTO == null) {
                    throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
                }
                // 通知评论
                createNotify(comment, dbComment.getCommentator(), commentator.getName(), questionDTO.getTitle(), NotificationTypeEnum.REPLY_COMMENT, questionDTO.getId());
            } else {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
        }
    }

    /**
     * 创建通知
     *
     * @param comment
     * @param receiver
     * @param notifierName
     * @param questionTitle
     * @param notificationType
     * @param outerId
     */
    private void createNotify(Comment comment, Long receiver, String notifierName, String questionTitle, NotificationTypeEnum notificationType, Long outerId) {
        if (receiver == comment.getCommentator()) {
            // 不给自己发通知
            return;
        }
        Notification notification = new Notification();
        notification.setReceiver(receiver);
        notification.setNotifier(comment.getCommentator());
        notification.setNotifierName(notifierName);
        notification.setOuterId(outerId);
        notification.setOuterTitle(questionTitle);
        notification.setGmtCreate(System.currentTimeMillis());
        notification.setType(notificationType.getType());
        notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());
        notificationService.insert(notification);
    }

    public List<CommentDTO> listByTargetId(Long id, CommentTypeEnum type) {
        // 获取所有该type类型的评论
        List<Comment> comments = commentExtMapper.listByTargetId(id, type);
        if (comments.isEmpty()) {
            return Collections.emptyList();
        }
        // 对评论人进行去重
        Set<Long> commentators = comments.stream().map(comment -> comment.getCommentator()).collect(Collectors.toSet());
        // 获取评论人并转为 map
        List<User> users = userService.findByIds(new ArrayList<>(commentators));
        Map<Long, User> userMap = users.stream().collect(Collectors.toMap(user -> user.getId(), user -> user));
        // 转换 comment 为 commentDTO
        List<CommentDTO> commentDTOS = comments.stream().map(comment -> {
            CommentDTO commentDTO = new CommentDTO();
            BeanUtils.copyProperties(comment, commentDTO);
            commentDTO.setUser(userMap.get(comment.getCommentator()));
            return commentDTO;
        }).collect(Collectors.toList());
        return commentDTOS;
    }
}
