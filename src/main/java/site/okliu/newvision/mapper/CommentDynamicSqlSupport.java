package site.okliu.newvision.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CommentDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.837+08:00", comments="Source Table: COMMENT")
    public static final Comment comment = new Comment();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.837+08:00", comments="Source field: COMMENT.ID")
    public static final SqlColumn<Long> id = comment.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.838+08:00", comments="Source field: COMMENT.PARENT_ID")
    public static final SqlColumn<Long> parentId = comment.parentId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.838+08:00", comments="Source field: COMMENT.TYPE")
    public static final SqlColumn<Integer> type = comment.type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.838+08:00", comments="Source field: COMMENT.COMMENTATOR")
    public static final SqlColumn<Long> commentator = comment.commentator;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.838+08:00", comments="Source field: COMMENT.GMT_CREATE")
    public static final SqlColumn<Long> gmtCreate = comment.gmtCreate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.838+08:00", comments="Source field: COMMENT.GMT_MODIFIED")
    public static final SqlColumn<Long> gmtModified = comment.gmtModified;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.838+08:00", comments="Source field: COMMENT.LIKE_COUNT")
    public static final SqlColumn<Long> likeCount = comment.likeCount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.838+08:00", comments="Source field: COMMENT.CONTENT")
    public static final SqlColumn<String> content = comment.content;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.838+08:00", comments="Source field: COMMENT.COMMENT_COUNT")
    public static final SqlColumn<Integer> commentCount = comment.commentCount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.837+08:00", comments="Source Table: COMMENT")
    public static final class Comment extends SqlTable {
        public final SqlColumn<Long> id = column("ID", JDBCType.BIGINT);

        public final SqlColumn<Long> parentId = column("PARENT_ID", JDBCType.BIGINT);

        public final SqlColumn<Integer> type = column("TYPE", JDBCType.INTEGER);

        public final SqlColumn<Long> commentator = column("COMMENTATOR", JDBCType.BIGINT);

        public final SqlColumn<Long> gmtCreate = column("GMT_CREATE", JDBCType.BIGINT);

        public final SqlColumn<Long> gmtModified = column("GMT_MODIFIED", JDBCType.BIGINT);

        public final SqlColumn<Long> likeCount = column("LIKE_COUNT", JDBCType.BIGINT);

        public final SqlColumn<String> content = column("CONTENT", JDBCType.VARCHAR);

        public final SqlColumn<Integer> commentCount = column("COMMENT_COUNT", JDBCType.INTEGER);

        public Comment() {
            super("COMMENT");
        }
    }
}