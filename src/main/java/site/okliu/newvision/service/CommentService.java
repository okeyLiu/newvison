package site.okliu.newvision.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.okliu.newvision.enums.CommentTypeEnum;
import site.okliu.newvision.exception.CustomizeErrorCode;
import site.okliu.newvision.exception.CustomizeException;
import site.okliu.newvision.mapper.CommentMapper;
import site.okliu.newvision.mapper.QuestionExtMapper;
import site.okliu.newvision.mapper.QuestionMapper;
import site.okliu.newvision.model.Comment;
import site.okliu.newvision.model.Question;

import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionExtMapper questionExtMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Transactional
    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if (comment.getType() == null || !CommentTypeEnum.isExists(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        if (comment.getType() == CommentTypeEnum.QUESTION.getType()) {
            // 回复问题
            Optional<Question> questionOptional = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (questionOptional.isPresent()) {
                commentMapper.insert(comment);
            } else {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            questionExtMapper.incCommentCount(comment.getParentId());
        } else {
            // 回复评论
            Optional<Comment> optionalComment = commentMapper.selectByPrimaryKey(comment.getId());
            if (optionalComment.isPresent()) {
                commentMapper.insert(comment);
            } else {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
        }
    }
}
