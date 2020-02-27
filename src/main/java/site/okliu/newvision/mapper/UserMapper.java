package site.okliu.newvision.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static site.okliu.newvision.mapper.UserDynamicSqlSupport.*;

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
import site.okliu.newvision.model.User;

@Mapper
public interface UserMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.24+08:00", comments="Source Table: USER")
    BasicColumn[] selectList = BasicColumn.columnList(id, accountId, name, token, gmtCreate, gmtModify, bio, avatarUrl);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.215+08:00", comments="Source Table: USER")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.216+08:00", comments="Source Table: USER")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.218+08:00", comments="Source Table: USER")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<User> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.219+08:00", comments="Source Table: USER")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<User> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.22+08:00", comments="Source Table: USER")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserResult")
    Optional<User> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.22+08:00", comments="Source Table: USER")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserResult", value = {
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ACCOUNT_ID", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="TOKEN", property="token", jdbcType=JdbcType.VARCHAR),
        @Result(column="GMT_CREATE", property="gmtCreate", jdbcType=JdbcType.BIGINT),
        @Result(column="GMT_MODIFY", property="gmtModify", jdbcType=JdbcType.BIGINT),
        @Result(column="BIO", property="bio", jdbcType=JdbcType.VARCHAR),
        @Result(column="AVATAR_URL", property="avatarUrl", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.225+08:00", comments="Source Table: USER")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.226+08:00", comments="Source Table: USER")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.226+08:00", comments="Source Table: USER")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.227+08:00", comments="Source Table: USER")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.228+08:00", comments="Source Table: USER")
    default int insert(User record) {
        return MyBatis3Utils.insert(this::insert, record, user, c ->
            c.map(id).toProperty("id")
            .map(accountId).toProperty("accountId")
            .map(name).toProperty("name")
            .map(token).toProperty("token")
            .map(gmtCreate).toProperty("gmtCreate")
            .map(gmtModify).toProperty("gmtModify")
            .map(bio).toProperty("bio")
            .map(avatarUrl).toProperty("avatarUrl")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.231+08:00", comments="Source Table: USER")
    default int insertMultiple(Collection<User> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, user, c ->
            c.map(id).toProperty("id")
            .map(accountId).toProperty("accountId")
            .map(name).toProperty("name")
            .map(token).toProperty("token")
            .map(gmtCreate).toProperty("gmtCreate")
            .map(gmtModify).toProperty("gmtModify")
            .map(bio).toProperty("bio")
            .map(avatarUrl).toProperty("avatarUrl")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.233+08:00", comments="Source Table: USER")
    default int insertSelective(User record) {
        return MyBatis3Utils.insert(this::insert, record, user, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(accountId).toPropertyWhenPresent("accountId", record::getAccountId)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(token).toPropertyWhenPresent("token", record::getToken)
            .map(gmtCreate).toPropertyWhenPresent("gmtCreate", record::getGmtCreate)
            .map(gmtModify).toPropertyWhenPresent("gmtModify", record::getGmtModify)
            .map(bio).toPropertyWhenPresent("bio", record::getBio)
            .map(avatarUrl).toPropertyWhenPresent("avatarUrl", record::getAvatarUrl)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.242+08:00", comments="Source Table: USER")
    default Optional<User> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.242+08:00", comments="Source Table: USER")
    default List<User> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.243+08:00", comments="Source Table: USER")
    default List<User> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.243+08:00", comments="Source Table: USER")
    default Optional<User> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.244+08:00", comments="Source Table: USER")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.245+08:00", comments="Source Table: USER")
    static UpdateDSL<UpdateModel> updateAllColumns(User record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(accountId).equalTo(record::getAccountId)
                .set(name).equalTo(record::getName)
                .set(token).equalTo(record::getToken)
                .set(gmtCreate).equalTo(record::getGmtCreate)
                .set(gmtModify).equalTo(record::getGmtModify)
                .set(bio).equalTo(record::getBio)
                .set(avatarUrl).equalTo(record::getAvatarUrl);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.246+08:00", comments="Source Table: USER")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(User record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(accountId).equalToWhenPresent(record::getAccountId)
                .set(name).equalToWhenPresent(record::getName)
                .set(token).equalToWhenPresent(record::getToken)
                .set(gmtCreate).equalToWhenPresent(record::getGmtCreate)
                .set(gmtModify).equalToWhenPresent(record::getGmtModify)
                .set(bio).equalToWhenPresent(record::getBio)
                .set(avatarUrl).equalToWhenPresent(record::getAvatarUrl);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.248+08:00", comments="Source Table: USER")
    default int updateByPrimaryKey(User record) {
        return update(c ->
            c.set(accountId).equalTo(record::getAccountId)
            .set(name).equalTo(record::getName)
            .set(token).equalTo(record::getToken)
            .set(gmtCreate).equalTo(record::getGmtCreate)
            .set(gmtModify).equalTo(record::getGmtModify)
            .set(bio).equalTo(record::getBio)
            .set(avatarUrl).equalTo(record::getAvatarUrl)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-27T15:48:49.25+08:00", comments="Source Table: USER")
    default int updateByPrimaryKeySelective(User record) {
        return update(c ->
            c.set(accountId).equalToWhenPresent(record::getAccountId)
            .set(name).equalToWhenPresent(record::getName)
            .set(token).equalToWhenPresent(record::getToken)
            .set(gmtCreate).equalToWhenPresent(record::getGmtCreate)
            .set(gmtModify).equalToWhenPresent(record::getGmtModify)
            .set(bio).equalToWhenPresent(record::getBio)
            .set(avatarUrl).equalToWhenPresent(record::getAvatarUrl)
            .where(id, isEqualTo(record::getId))
        );
    }
}