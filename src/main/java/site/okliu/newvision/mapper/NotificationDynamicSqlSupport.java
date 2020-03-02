package site.okliu.newvision.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class NotificationDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source Table: NOTIFICATION")
    public static final Notification notification = new Notification();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.217+08:00", comments="Source field: NOTIFICATION.ID")
    public static final SqlColumn<Long> id = notification.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.217+08:00", comments="Source field: NOTIFICATION.NOTIFIER")
    public static final SqlColumn<Long> notifier = notification.notifier;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.217+08:00", comments="Source field: NOTIFICATION.NOTIFIER_NAME")
    public static final SqlColumn<String> notifierName = notification.notifierName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.217+08:00", comments="Source field: NOTIFICATION.RECEIVER")
    public static final SqlColumn<Long> receiver = notification.receiver;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.217+08:00", comments="Source field: NOTIFICATION.OUTER_ID")
    public static final SqlColumn<Long> outerId = notification.outerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.217+08:00", comments="Source field: NOTIFICATION.OUTER_TITLE")
    public static final SqlColumn<String> outerTitle = notification.outerTitle;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.217+08:00", comments="Source field: NOTIFICATION.TYPE")
    public static final SqlColumn<Integer> type = notification.type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.217+08:00", comments="Source field: NOTIFICATION.GMT_CREATE")
    public static final SqlColumn<Long> gmtCreate = notification.gmtCreate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.217+08:00", comments="Source field: NOTIFICATION.STATUS")
    public static final SqlColumn<Integer> status = notification.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.217+08:00", comments="Source Table: NOTIFICATION")
    public static final class Notification extends SqlTable {
        public final SqlColumn<Long> id = column("ID", JDBCType.BIGINT);

        public final SqlColumn<Long> notifier = column("NOTIFIER", JDBCType.BIGINT);

        public final SqlColumn<String> notifierName = column("NOTIFIER_NAME", JDBCType.VARCHAR);

        public final SqlColumn<Long> receiver = column("RECEIVER", JDBCType.BIGINT);

        public final SqlColumn<Long> outerId = column("OUTER_ID", JDBCType.BIGINT);

        public final SqlColumn<String> outerTitle = column("OUTER_TITLE", JDBCType.VARCHAR);

        public final SqlColumn<Integer> type = column("TYPE", JDBCType.INTEGER);

        public final SqlColumn<Long> gmtCreate = column("GMT_CREATE", JDBCType.BIGINT);

        public final SqlColumn<Integer> status = column("STATUS", JDBCType.INTEGER);

        public Notification() {
            super("NOTIFICATION");
        }
    }
}