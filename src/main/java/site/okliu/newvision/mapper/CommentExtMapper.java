package site.okliu.newvision.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import site.okliu.newvision.enums.CommentTypeEnum;
import site.okliu.newvision.model.Comment;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static site.okliu.newvision.mapper.CommentDynamicSqlSupport.*;

@Repository
public class CommentExtMapper {

    private CommentMapper commentMapper;

    @Autowired
    public CommentExtMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    /**
     * 根据类型返回评论列表
     *
     * @param id
     * @param commentType
     * @return
     */
    public List<Comment> listByTargetId(Long id, CommentTypeEnum commentType) {
        return commentMapper.select(c -> c.where(parentId, isEqualTo(id)).and(type, isEqualTo(commentType.getType())).orderBy(gmtCreate.descending()));
    }

    /**
     * 增加评论数量
     *
     * @param targetId
     */
    public void incCommentCount(Long targetId) {
        // 此处使用“comment_count+1” 含义是 使用执行数据库是 comment_count 列的值+1，避免并发错误
        commentMapper.update(c ->
                c.set(commentCount).equalToConstant("COMMENT_COUNT+1")
                        .where(id, isEqualTo(targetId))
        );
    }
}
