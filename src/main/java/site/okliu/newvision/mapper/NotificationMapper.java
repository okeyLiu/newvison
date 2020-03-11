package site.okliu.newvision.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static site.okliu.newvision.mapper.NotificationDynamicSqlSupport.*;

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
import site.okliu.newvision.model.Notification;

@Mapper
public interface NotificationMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.844+08:00", comments="Source Table: NOTIFICATION")
    BasicColumn[] selectList = BasicColumn.columnList(id, notifier, notifierName, receiver, outerId, outerTitle, type, gmtCreate, status);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.843+08:00", comments="Source Table: NOTIFICATION")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.843+08:00", comments="Source Table: NOTIFICATION")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.844+08:00", comments="Source Table: NOTIFICATION")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Notification> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.844+08:00", comments="Source Table: NOTIFICATION")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Notification> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.844+08:00", comments="Source Table: NOTIFICATION")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("NotificationResult")
    Optional<Notification> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.844+08:00", comments="Source Table: NOTIFICATION")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="NotificationResult", value = {
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="NOTIFIER", property="notifier", jdbcType=JdbcType.BIGINT),
        @Result(column="NOTIFIER_NAME", property="notifierName", jdbcType=JdbcType.VARCHAR),
        @Result(column="RECEIVER", property="receiver", jdbcType=JdbcType.BIGINT),
        @Result(column="OUTER_ID", property="outerId", jdbcType=JdbcType.BIGINT),
        @Result(column="OUTER_TITLE", property="outerTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="GMT_CREATE", property="gmtCreate", jdbcType=JdbcType.BIGINT),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<Notification> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.844+08:00", comments="Source Table: NOTIFICATION")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.844+08:00", comments="Source Table: NOTIFICATION")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, notification, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.844+08:00", comments="Source Table: NOTIFICATION")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, notification, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.844+08:00", comments="Source Table: NOTIFICATION")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.844+08:00", comments="Source Table: NOTIFICATION")
    default int insert(Notification record) {
        return MyBatis3Utils.insert(this::insert, record, notification, c ->
            c.map(id).toProperty("id")
            .map(notifier).toProperty("notifier")
            .map(notifierName).toProperty("notifierName")
            .map(receiver).toProperty("receiver")
            .map(outerId).toProperty("outerId")
            .map(outerTitle).toProperty("outerTitle")
            .map(type).toProperty("type")
            .map(gmtCreate).toProperty("gmtCreate")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.844+08:00", comments="Source Table: NOTIFICATION")
    default int insertMultiple(Collection<Notification> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, notification, c ->
            c.map(id).toProperty("id")
            .map(notifier).toProperty("notifier")
            .map(notifierName).toProperty("notifierName")
            .map(receiver).toProperty("receiver")
            .map(outerId).toProperty("outerId")
            .map(outerTitle).toProperty("outerTitle")
            .map(type).toProperty("type")
            .map(gmtCreate).toProperty("gmtCreate")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.844+08:00", comments="Source Table: NOTIFICATION")
    default int insertSelective(Notification record) {
        return MyBatis3Utils.insert(this::insert, record, notification, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(notifier).toPropertyWhenPresent("notifier", record::getNotifier)
            .map(notifierName).toPropertyWhenPresent("notifierName", record::getNotifierName)
            .map(receiver).toPropertyWhenPresent("receiver", record::getReceiver)
            .map(outerId).toPropertyWhenPresent("outerId", record::getOuterId)
            .map(outerTitle).toPropertyWhenPresent("outerTitle", record::getOuterTitle)
            .map(type).toPropertyWhenPresent("type", record::getType)
            .map(gmtCreate).toPropertyWhenPresent("gmtCreate", record::getGmtCreate)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.844+08:00", comments="Source Table: NOTIFICATION")
    default Optional<Notification> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, notification, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.844+08:00", comments="Source Table: NOTIFICATION")
    default List<Notification> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, notification, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.844+08:00", comments="Source Table: NOTIFICATION")
    default List<Notification> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, notification, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.845+08:00", comments="Source Table: NOTIFICATION")
    default Optional<Notification> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.845+08:00", comments="Source Table: NOTIFICATION")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, notification, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.845+08:00", comments="Source Table: NOTIFICATION")
    static UpdateDSL<UpdateModel> updateAllColumns(Notification record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(notifier).equalTo(record::getNotifier)
                .set(notifierName).equalTo(record::getNotifierName)
                .set(receiver).equalTo(record::getReceiver)
                .set(outerId).equalTo(record::getOuterId)
                .set(outerTitle).equalTo(record::getOuterTitle)
                .set(type).equalTo(record::getType)
                .set(gmtCreate).equalTo(record::getGmtCreate)
                .set(status).equalTo(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.845+08:00", comments="Source Table: NOTIFICATION")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Notification record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(notifier).equalToWhenPresent(record::getNotifier)
                .set(notifierName).equalToWhenPresent(record::getNotifierName)
                .set(receiver).equalToWhenPresent(record::getReceiver)
                .set(outerId).equalToWhenPresent(record::getOuterId)
                .set(outerTitle).equalToWhenPresent(record::getOuterTitle)
                .set(type).equalToWhenPresent(record::getType)
                .set(gmtCreate).equalToWhenPresent(record::getGmtCreate)
                .set(status).equalToWhenPresent(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.845+08:00", comments="Source Table: NOTIFICATION")
    default int updateByPrimaryKey(Notification record) {
        return update(c ->
            c.set(notifier).equalTo(record::getNotifier)
            .set(notifierName).equalTo(record::getNotifierName)
            .set(receiver).equalTo(record::getReceiver)
            .set(outerId).equalTo(record::getOuterId)
            .set(outerTitle).equalTo(record::getOuterTitle)
            .set(type).equalTo(record::getType)
            .set(gmtCreate).equalTo(record::getGmtCreate)
            .set(status).equalTo(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.845+08:00", comments="Source Table: NOTIFICATION")
    default int updateByPrimaryKeySelective(Notification record) {
        return update(c ->
            c.set(notifier).equalToWhenPresent(record::getNotifier)
            .set(notifierName).equalToWhenPresent(record::getNotifierName)
            .set(receiver).equalToWhenPresent(record::getReceiver)
            .set(outerId).equalToWhenPresent(record::getOuterId)
            .set(outerTitle).equalToWhenPresent(record::getOuterTitle)
            .set(type).equalToWhenPresent(record::getType)
            .set(gmtCreate).equalToWhenPresent(record::getGmtCreate)
            .set(status).equalToWhenPresent(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }
}