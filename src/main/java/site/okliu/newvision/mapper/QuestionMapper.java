package site.okliu.newvision.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static site.okliu.newvision.mapper.QuestionDynamicSqlSupport.*;

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
import site.okliu.newvision.model.Question;

@Mapper
public interface QuestionMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.834+08:00", comments="Source Table: QUESTION")
    BasicColumn[] selectList = BasicColumn.columnList(id, title, gmtCreate, gmtModify, creator, commentCount, viewCount, likeCount, tag, description);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.833+08:00", comments="Source Table: QUESTION")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.833+08:00", comments="Source Table: QUESTION")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.833+08:00", comments="Source Table: QUESTION")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Question> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.833+08:00", comments="Source Table: QUESTION")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Question> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.833+08:00", comments="Source Table: QUESTION")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("QuestionResult")
    Optional<Question> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.833+08:00", comments="Source Table: QUESTION")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="QuestionResult", value = {
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="TITLE", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="GMT_CREATE", property="gmtCreate", jdbcType=JdbcType.BIGINT),
        @Result(column="GMT_MODIFY", property="gmtModify", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATOR", property="creator", jdbcType=JdbcType.BIGINT),
        @Result(column="COMMENT_COUNT", property="commentCount", jdbcType=JdbcType.INTEGER),
        @Result(column="VIEW_COUNT", property="viewCount", jdbcType=JdbcType.INTEGER),
        @Result(column="LIKE_COUNT", property="likeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="TAG", property="tag", jdbcType=JdbcType.VARCHAR),
        @Result(column="DESCRIPTION", property="description", jdbcType=JdbcType.CLOB)
    })
    List<Question> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.834+08:00", comments="Source Table: QUESTION")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.834+08:00", comments="Source Table: QUESTION")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, question, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.834+08:00", comments="Source Table: QUESTION")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, question, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.834+08:00", comments="Source Table: QUESTION")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.834+08:00", comments="Source Table: QUESTION")
    default int insert(Question record) {
        return MyBatis3Utils.insert(this::insert, record, question, c ->
            c.map(id).toProperty("id")
            .map(title).toProperty("title")
            .map(gmtCreate).toProperty("gmtCreate")
            .map(gmtModify).toProperty("gmtModify")
            .map(creator).toProperty("creator")
            .map(commentCount).toProperty("commentCount")
            .map(viewCount).toProperty("viewCount")
            .map(likeCount).toProperty("likeCount")
            .map(tag).toProperty("tag")
            .map(description).toProperty("description")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.834+08:00", comments="Source Table: QUESTION")
    default int insertMultiple(Collection<Question> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, question, c ->
            c.map(id).toProperty("id")
            .map(title).toProperty("title")
            .map(gmtCreate).toProperty("gmtCreate")
            .map(gmtModify).toProperty("gmtModify")
            .map(creator).toProperty("creator")
            .map(commentCount).toProperty("commentCount")
            .map(viewCount).toProperty("viewCount")
            .map(likeCount).toProperty("likeCount")
            .map(tag).toProperty("tag")
            .map(description).toProperty("description")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.834+08:00", comments="Source Table: QUESTION")
    default int insertSelective(Question record) {
        return MyBatis3Utils.insert(this::insert, record, question, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(title).toPropertyWhenPresent("title", record::getTitle)
            .map(gmtCreate).toPropertyWhenPresent("gmtCreate", record::getGmtCreate)
            .map(gmtModify).toPropertyWhenPresent("gmtModify", record::getGmtModify)
            .map(creator).toPropertyWhenPresent("creator", record::getCreator)
            .map(commentCount).toPropertyWhenPresent("commentCount", record::getCommentCount)
            .map(viewCount).toPropertyWhenPresent("viewCount", record::getViewCount)
            .map(likeCount).toPropertyWhenPresent("likeCount", record::getLikeCount)
            .map(tag).toPropertyWhenPresent("tag", record::getTag)
            .map(description).toPropertyWhenPresent("description", record::getDescription)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.834+08:00", comments="Source Table: QUESTION")
    default Optional<Question> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, question, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.834+08:00", comments="Source Table: QUESTION")
    default List<Question> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, question, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.834+08:00", comments="Source Table: QUESTION")
    default List<Question> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, question, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.834+08:00", comments="Source Table: QUESTION")
    default Optional<Question> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.835+08:00", comments="Source Table: QUESTION")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, question, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.835+08:00", comments="Source Table: QUESTION")
    static UpdateDSL<UpdateModel> updateAllColumns(Question record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(title).equalTo(record::getTitle)
                .set(gmtCreate).equalTo(record::getGmtCreate)
                .set(gmtModify).equalTo(record::getGmtModify)
                .set(creator).equalTo(record::getCreator)
                .set(commentCount).equalTo(record::getCommentCount)
                .set(viewCount).equalTo(record::getViewCount)
                .set(likeCount).equalTo(record::getLikeCount)
                .set(tag).equalTo(record::getTag)
                .set(description).equalTo(record::getDescription);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.835+08:00", comments="Source Table: QUESTION")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Question record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(title).equalToWhenPresent(record::getTitle)
                .set(gmtCreate).equalToWhenPresent(record::getGmtCreate)
                .set(gmtModify).equalToWhenPresent(record::getGmtModify)
                .set(creator).equalToWhenPresent(record::getCreator)
                .set(commentCount).equalToWhenPresent(record::getCommentCount)
                .set(viewCount).equalToWhenPresent(record::getViewCount)
                .set(likeCount).equalToWhenPresent(record::getLikeCount)
                .set(tag).equalToWhenPresent(record::getTag)
                .set(description).equalToWhenPresent(record::getDescription);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.835+08:00", comments="Source Table: QUESTION")
    default int updateByPrimaryKey(Question record) {
        return update(c ->
            c.set(title).equalTo(record::getTitle)
            .set(gmtCreate).equalTo(record::getGmtCreate)
            .set(gmtModify).equalTo(record::getGmtModify)
            .set(creator).equalTo(record::getCreator)
            .set(commentCount).equalTo(record::getCommentCount)
            .set(viewCount).equalTo(record::getViewCount)
            .set(likeCount).equalTo(record::getLikeCount)
            .set(tag).equalTo(record::getTag)
            .set(description).equalTo(record::getDescription)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.835+08:00", comments="Source Table: QUESTION")
    default int updateByPrimaryKeySelective(Question record) {
        return update(c ->
            c.set(title).equalToWhenPresent(record::getTitle)
            .set(gmtCreate).equalToWhenPresent(record::getGmtCreate)
            .set(gmtModify).equalToWhenPresent(record::getGmtModify)
            .set(creator).equalToWhenPresent(record::getCreator)
            .set(commentCount).equalToWhenPresent(record::getCommentCount)
            .set(viewCount).equalToWhenPresent(record::getViewCount)
            .set(likeCount).equalToWhenPresent(record::getLikeCount)
            .set(tag).equalToWhenPresent(record::getTag)
            .set(description).equalToWhenPresent(record::getDescription)
            .where(id, isEqualTo(record::getId))
        );
    }
}