package site.okliu.newvision.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.168+08:00", comments="Source Table: USER")
    public static final User user = new User();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.168+08:00", comments="Source field: USER.ID")
    public static final SqlColumn<Long> id = user.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.169+08:00", comments="Source field: USER.ACCOUNT_ID")
    public static final SqlColumn<String> accountId = user.accountId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.169+08:00", comments="Source field: USER.NAME")
    public static final SqlColumn<String> name = user.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.169+08:00", comments="Source field: USER.TOKEN")
    public static final SqlColumn<String> token = user.token;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.169+08:00", comments="Source field: USER.GMT_CREATE")
    public static final SqlColumn<Long> gmtCreate = user.gmtCreate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.169+08:00", comments="Source field: USER.GMT_MODIFY")
    public static final SqlColumn<Long> gmtModify = user.gmtModify;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.169+08:00", comments="Source field: USER.BIO")
    public static final SqlColumn<String> bio = user.bio;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.17+08:00", comments="Source field: USER.AVATAR_URL")
    public static final SqlColumn<String> avatarUrl = user.avatarUrl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.168+08:00", comments="Source Table: USER")
    public static final class User extends SqlTable {
        public final SqlColumn<Long> id = column("ID", JDBCType.BIGINT);

        public final SqlColumn<String> accountId = column("ACCOUNT_ID", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("NAME", JDBCType.VARCHAR);

        public final SqlColumn<String> token = column("TOKEN", JDBCType.VARCHAR);

        public final SqlColumn<Long> gmtCreate = column("GMT_CREATE", JDBCType.BIGINT);

        public final SqlColumn<Long> gmtModify = column("GMT_MODIFY", JDBCType.BIGINT);

        public final SqlColumn<String> bio = column("BIO", JDBCType.VARCHAR);

        public final SqlColumn<String> avatarUrl = column("AVATAR_URL", JDBCType.VARCHAR);

        public User() {
            super("USER");
        }
    }
}