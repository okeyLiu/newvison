package site.okliu.newvision.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static site.okliu.newvision.mapper.AdDynamicSqlSupport.*;

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
import site.okliu.newvision.model.Ad;

@Mapper
public interface AdMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.849+08:00", comments="Source Table: AD")
    BasicColumn[] selectList = BasicColumn.columnList(id, title, url, image, gmtCreate, gmtModify, gmtStart, gmtEnd, status, pos);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.848+08:00", comments="Source Table: AD")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.848+08:00", comments="Source Table: AD")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.848+08:00", comments="Source Table: AD")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Ad> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.848+08:00", comments="Source Table: AD")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Ad> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.849+08:00", comments="Source Table: AD")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AdResult")
    Optional<Ad> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.849+08:00", comments="Source Table: AD")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AdResult", value = {
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="TITLE", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="URL", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="IMAGE", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="GMT_CREATE", property="gmtCreate", jdbcType=JdbcType.BIGINT),
        @Result(column="GMT_MODIFY", property="gmtModify", jdbcType=JdbcType.BIGINT),
        @Result(column="GMT_START", property="gmtStart", jdbcType=JdbcType.BIGINT),
        @Result(column="GMT_END", property="gmtEnd", jdbcType=JdbcType.BIGINT),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="POS", property="pos", jdbcType=JdbcType.VARCHAR)
    })
    List<Ad> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.849+08:00", comments="Source Table: AD")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.849+08:00", comments="Source Table: AD")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ad, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.849+08:00", comments="Source Table: AD")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ad, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.849+08:00", comments="Source Table: AD")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.849+08:00", comments="Source Table: AD")
    default int insert(Ad record) {
        return MyBatis3Utils.insert(this::insert, record, ad, c ->
            c.map(id).toProperty("id")
            .map(title).toProperty("title")
            .map(url).toProperty("url")
            .map(image).toProperty("image")
            .map(gmtCreate).toProperty("gmtCreate")
            .map(gmtModify).toProperty("gmtModify")
            .map(gmtStart).toProperty("gmtStart")
            .map(gmtEnd).toProperty("gmtEnd")
            .map(status).toProperty("status")
            .map(pos).toProperty("pos")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.849+08:00", comments="Source Table: AD")
    default int insertMultiple(Collection<Ad> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ad, c ->
            c.map(id).toProperty("id")
            .map(title).toProperty("title")
            .map(url).toProperty("url")
            .map(image).toProperty("image")
            .map(gmtCreate).toProperty("gmtCreate")
            .map(gmtModify).toProperty("gmtModify")
            .map(gmtStart).toProperty("gmtStart")
            .map(gmtEnd).toProperty("gmtEnd")
            .map(status).toProperty("status")
            .map(pos).toProperty("pos")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.849+08:00", comments="Source Table: AD")
    default int insertSelective(Ad record) {
        return MyBatis3Utils.insert(this::insert, record, ad, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(title).toPropertyWhenPresent("title", record::getTitle)
            .map(url).toPropertyWhenPresent("url", record::getUrl)
            .map(image).toPropertyWhenPresent("image", record::getImage)
            .map(gmtCreate).toPropertyWhenPresent("gmtCreate", record::getGmtCreate)
            .map(gmtModify).toPropertyWhenPresent("gmtModify", record::getGmtModify)
            .map(gmtStart).toPropertyWhenPresent("gmtStart", record::getGmtStart)
            .map(gmtEnd).toPropertyWhenPresent("gmtEnd", record::getGmtEnd)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(pos).toPropertyWhenPresent("pos", record::getPos)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.849+08:00", comments="Source Table: AD")
    default Optional<Ad> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ad, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.85+08:00", comments="Source Table: AD")
    default List<Ad> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ad, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.85+08:00", comments="Source Table: AD")
    default List<Ad> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ad, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.85+08:00", comments="Source Table: AD")
    default Optional<Ad> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.85+08:00", comments="Source Table: AD")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ad, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.85+08:00", comments="Source Table: AD")
    static UpdateDSL<UpdateModel> updateAllColumns(Ad record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(title).equalTo(record::getTitle)
                .set(url).equalTo(record::getUrl)
                .set(image).equalTo(record::getImage)
                .set(gmtCreate).equalTo(record::getGmtCreate)
                .set(gmtModify).equalTo(record::getGmtModify)
                .set(gmtStart).equalTo(record::getGmtStart)
                .set(gmtEnd).equalTo(record::getGmtEnd)
                .set(status).equalTo(record::getStatus)
                .set(pos).equalTo(record::getPos);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.85+08:00", comments="Source Table: AD")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Ad record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(title).equalToWhenPresent(record::getTitle)
                .set(url).equalToWhenPresent(record::getUrl)
                .set(image).equalToWhenPresent(record::getImage)
                .set(gmtCreate).equalToWhenPresent(record::getGmtCreate)
                .set(gmtModify).equalToWhenPresent(record::getGmtModify)
                .set(gmtStart).equalToWhenPresent(record::getGmtStart)
                .set(gmtEnd).equalToWhenPresent(record::getGmtEnd)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(pos).equalToWhenPresent(record::getPos);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.85+08:00", comments="Source Table: AD")
    default int updateByPrimaryKey(Ad record) {
        return update(c ->
            c.set(title).equalTo(record::getTitle)
            .set(url).equalTo(record::getUrl)
            .set(image).equalTo(record::getImage)
            .set(gmtCreate).equalTo(record::getGmtCreate)
            .set(gmtModify).equalTo(record::getGmtModify)
            .set(gmtStart).equalTo(record::getGmtStart)
            .set(gmtEnd).equalTo(record::getGmtEnd)
            .set(status).equalTo(record::getStatus)
            .set(pos).equalTo(record::getPos)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.851+08:00", comments="Source Table: AD")
    default int updateByPrimaryKeySelective(Ad record) {
        return update(c ->
            c.set(title).equalToWhenPresent(record::getTitle)
            .set(url).equalToWhenPresent(record::getUrl)
            .set(image).equalToWhenPresent(record::getImage)
            .set(gmtCreate).equalToWhenPresent(record::getGmtCreate)
            .set(gmtModify).equalToWhenPresent(record::getGmtModify)
            .set(gmtStart).equalToWhenPresent(record::getGmtStart)
            .set(gmtEnd).equalToWhenPresent(record::getGmtEnd)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(pos).equalToWhenPresent(record::getPos)
            .where(id, isEqualTo(record::getId))
        );
    }
}