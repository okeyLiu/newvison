package site.okliu.newvision.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import site.okliu.newvision.enums.CommentTypeEnum;
import site.okliu.newvision.model.Comment;
import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static site.okliu.newvision.mapper.CommentDynamicSqlSupport.*;
import java.util.List;

@Repository
public class CommentExtMapper {

    @Autowired
    private CommentMapper commentMapper;

    public List<Comment> listByTargetId(Long id, CommentTypeEnum commentType) {
        return commentMapper.select(c -> c.where(parentId, isEqualTo(id)).and(type, isEqualTo(commentType.getType())).orderBy(gmtCreate.descending()));
    }
}
