package site.okliu.newvision.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static site.okliu.newvision.mapper.CommentDynamicSqlSupport.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;
import site.okliu.newvision.model.Comment;

@Mapper
public interface CommentMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.84+08:00", comments="Source Table: COMMENT")
    BasicColumn[] selectList = BasicColumn.columnList(id, parentId, type, commentator, gmtCreate, gmtModified, likeCount, content, commentCount);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.839+08:00", comments="Source Table: COMMENT")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.839+08:00", comments="Source Table: COMMENT")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.839+08:00", comments="Source Table: COMMENT")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Comment> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.839+08:00", comments="Source Table: COMMENT")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Comment> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.839+08:00", comments="Source Table: COMMENT")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CommentResult")
    Optional<Comment> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.839+08:00", comments="Source Table: COMMENT")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CommentResult", value = {
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="PARENT_ID", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="COMMENTATOR", property="commentator", jdbcType=JdbcType.BIGINT),
        @Result(column="GMT_CREATE", property="gmtCreate", jdbcType=JdbcType.BIGINT),
        @Result(column="GMT_MODIFIED", property="gmtModified", jdbcType=JdbcType.BIGINT),
        @Result(column="LIKE_COUNT", property="likeCount", jdbcType=JdbcType.BIGINT),
        @Result(column="CONTENT", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="COMMENT_COUNT", property="commentCount", jdbcType=JdbcType.INTEGER)
    })
    List<Comment> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.839+08:00", comments="Source Table: COMMENT")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.839+08:00", comments="Source Table: COMMENT")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.839+08:00", comments="Source Table: COMMENT")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.839+08:00", comments="Source Table: COMMENT")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.84+08:00", comments="Source Table: COMMENT")
    default int insert(Comment record) {
        return MyBatis3Utils.insert(this::insert, record, comment, c ->
            c.map(id).toProperty("id")
            .map(parentId).toProperty("parentId")
            .map(type).toProperty("type")
            .map(commentator).toProperty("commentator")
            .map(gmtCreate).toProperty("gmtCreate")
            .map(gmtModified).toProperty("gmtModified")
            .map(likeCount).toProperty("likeCount")
            .map(content).toProperty("content")
            .map(commentCount).toProperty("commentCount")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.84+08:00", comments="Source Table: COMMENT")
    default int insertMultiple(Collection<Comment> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, comment, c ->
            c.map(id).toProperty("id")
            .map(parentId).toProperty("parentId")
            .map(type).toProperty("type")
            .map(commentator).toProperty("commentator")
            .map(gmtCreate).toProperty("gmtCreate")
            .map(gmtModified).toProperty("gmtModified")
            .map(likeCount).toProperty("likeCount")
            .map(content).toProperty("content")
            .map(commentCount).toProperty("commentCount")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.84+08:00", comments="Source Table: COMMENT")
    default int insertSelective(Comment record) {
        return MyBatis3Utils.insert(this::insert, record, comment, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(parentId).toPropertyWhenPresent("parentId", record::getParentId)
            .map(type).toPropertyWhenPresent("type", record::getType)
            .map(commentator).toPropertyWhenPresent("commentator", record::getCommentator)
            .map(gmtCreate).toPropertyWhenPresent("gmtCreate", record::getGmtCreate)
            .map(gmtModified).toPropertyWhenPresent("gmtModified", record::getGmtModified)
            .map(likeCount).toPropertyWhenPresent("likeCount", record::getLikeCount)
            .map(content).toPropertyWhenPresent("content", record::getContent)
            .map(commentCount).toPropertyWhenPresent("commentCount", record::getCommentCount)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.84+08:00", comments="Source Table: COMMENT")
    default Optional<Comment> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.84+08:00", comments="Source Table: COMMENT")
    default List<Comment> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.84+08:00", comments="Source Table: COMMENT")
    default List<Comment> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.84+08:00", comments="Source Table: COMMENT")
    default Optional<Comment> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.84+08:00", comments="Source Table: COMMENT")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.84+08:00", comments="Source Table: COMMENT")
    static UpdateDSL<UpdateModel> updateAllColumns(Comment record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(parentId).equalTo(record::getParentId)
                .set(type).equalTo(record::getType)
                .set(commentator).equalTo(record::getCommentator)
                .set(gmtCreate).equalTo(record::getGmtCreate)
                .set(gmtModified).equalTo(record::getGmtModified)
                .set(likeCount).equalTo(record::getLikeCount)
                .set(content).equalTo(record::getContent)
                .set(commentCount).equalTo(record::getCommentCount);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.84+08:00", comments="Source Table: COMMENT")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Comment record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(parentId).equalToWhenPresent(record::getParentId)
                .set(type).equalToWhenPresent(record::getType)
                .set(commentator).equalToWhenPresent(record::getCommentator)
                .set(gmtCreate).equalToWhenPresent(record::getGmtCreate)
                .set(gmtModified).equalToWhenPresent(record::getGmtModified)
                .set(likeCount).equalToWhenPresent(record::getLikeCount)
                .set(content).equalToWhenPresent(record::getContent)
                .set(commentCount).equalToWhenPresent(record::getCommentCount);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.841+08:00", comments="Source Table: COMMENT")
    default int updateByPrimaryKey(Comment record) {
        return update(c ->
            c.set(parentId).equalTo(record::getParentId)
            .set(type).equalTo(record::getType)
            .set(commentator).equalTo(record::getCommentator)
            .set(gmtCreate).equalTo(record::getGmtCreate)
            .set(gmtModified).equalTo(record::getGmtModified)
            .set(likeCount).equalTo(record::getLikeCount)
            .set(content).equalTo(record::getContent)
            .set(commentCount).equalTo(record::getCommentCount)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.841+08:00", comments="Source Table: COMMENT")
    default int updateByPrimaryKeySelective(Comment record) {
        return update(c ->
            c.set(parentId).equalToWhenPresent(record::getParentId)
            .set(type).equalToWhenPresent(record::getType)
            .set(commentator).equalToWhenPresent(record::getCommentator)
            .set(gmtCreate).equalToWhenPresent(record::getGmtCreate)
            .set(gmtModified).equalToWhenPresent(record::getGmtModified)
            .set(likeCount).equalToWhenPresent(record::getLikeCount)
            .set(content).equalToWhenPresent(record::getContent)
            .set(commentCount).equalToWhenPresent(record::getCommentCount)
            .where(id, isEqualTo(record::getId))
        );
    }
}