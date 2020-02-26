package site.okliu.newvision.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.okliu.newvision.dto.CommentDTO;
import site.okliu.newvision.dto.QuestionDTO;
import site.okliu.newvision.enums.CommentTypeEnum;
import site.okliu.newvision.exception.CustomizeErrorCode;
import site.okliu.newvision.exception.CustomizeException;
import site.okliu.newvision.mapper.CommentExtMapper;
import site.okliu.newvision.mapper.CommentMapper;
import site.okliu.newvision.model.Comment;
import site.okliu.newvision.model.User;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentExtMapper commentExtMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private QuestionService questionService;

    @Transactional
    public void insert(Comment comment) {
        if (comment.getType() == CommentTypeEnum.QUESTION.getType()) {
            // 回复问题
            QuestionDTO questionDTO = questionService.findById(comment.getParentId());
            if (questionDTO == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);
            questionService.incCommentCount(comment.getParentId());
        } else {
            // 回复评论
            Optional<Comment> optionalComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (optionalComment.isPresent()) {
                commentMapper.insert(comment);
            } else {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
        }
    }

    public List<CommentDTO> listByTargetId(Long id, CommentTypeEnum type) {
        // 获取所有该type类型的评论
        List<Comment> comments = commentExtMapper.listByTargetId(id,type);
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
