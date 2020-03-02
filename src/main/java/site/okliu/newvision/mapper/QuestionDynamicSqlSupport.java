package site.okliu.newvision.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class QuestionDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.206+08:00", comments="Source Table: QUESTION")
    public static final Question question = new Question();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.206+08:00", comments="Source field: QUESTION.ID")
    public static final SqlColumn<Long> id = question.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.206+08:00", comments="Source field: QUESTION.TITLE")
    public static final SqlColumn<String> title = question.title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.206+08:00", comments="Source field: QUESTION.GMT_CREATE")
    public static final SqlColumn<Long> gmtCreate = question.gmtCreate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.207+08:00", comments="Source field: QUESTION.GMT_MODIFY")
    public static final SqlColumn<Long> gmtModify = question.gmtModify;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.207+08:00", comments="Source field: QUESTION.CREATOR")
    public static final SqlColumn<Long> creator = question.creator;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.207+08:00", comments="Source field: QUESTION.COMMENT_COUNT")
    public static final SqlColumn<Integer> commentCount = question.commentCount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.207+08:00", comments="Source field: QUESTION.VIEW_COUNT")
    public static final SqlColumn<Integer> viewCount = question.viewCount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.207+08:00", comments="Source field: QUESTION.LIKE_COUNT")
    public static final SqlColumn<Integer> likeCount = question.likeCount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.207+08:00", comments="Source field: QUESTION.TAG")
    public static final SqlColumn<String> tag = question.tag;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.207+08:00", comments="Source field: QUESTION.DESCRIPTION")
    public static final SqlColumn<String> description = question.description;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.206+08:00", comments="Source Table: QUESTION")
    public static final class Question extends SqlTable {
        public final SqlColumn<Long> id = column("ID", JDBCType.BIGINT);

        public final SqlColumn<String> title = column("TITLE", JDBCType.VARCHAR);

        public final SqlColumn<Long> gmtCreate = column("GMT_CREATE", JDBCType.BIGINT);

        public final SqlColumn<Long> gmtModify = column("GMT_MODIFY", JDBCType.BIGINT);

        public final SqlColumn<Long> creator = column("CREATOR", JDBCType.BIGINT);

        public final SqlColumn<Integer> commentCount = column("COMMENT_COUNT", JDBCType.INTEGER);

        public final SqlColumn<Integer> viewCount = column("VIEW_COUNT", JDBCType.INTEGER);

        public final SqlColumn<Integer> likeCount = column("LIKE_COUNT", JDBCType.INTEGER);

        public final SqlColumn<String> tag = column("TAG", JDBCType.VARCHAR);

        public final SqlColumn<String> description = column("DESCRIPTION", JDBCType.CLOB);

        public Question() {
            super("QUESTION");
        }
    }
}