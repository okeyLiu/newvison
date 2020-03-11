package site.okliu.newvision.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class AdDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.847+08:00", comments="Source Table: AD")
    public static final Ad ad = new Ad();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.847+08:00", comments="Source field: AD.ID")
    public static final SqlColumn<Integer> id = ad.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.847+08:00", comments="Source field: AD.TITLE")
    public static final SqlColumn<String> title = ad.title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.847+08:00", comments="Source field: AD.URL")
    public static final SqlColumn<String> url = ad.url;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.847+08:00", comments="Source field: AD.IMAGE")
    public static final SqlColumn<String> image = ad.image;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.848+08:00", comments="Source field: AD.GMT_CREATE")
    public static final SqlColumn<Long> gmtCreate = ad.gmtCreate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.848+08:00", comments="Source field: AD.GMT_MODIFY")
    public static final SqlColumn<Long> gmtModify = ad.gmtModify;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.848+08:00", comments="Source field: AD.GMT_START")
    public static final SqlColumn<Long> gmtStart = ad.gmtStart;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.848+08:00", comments="Source field: AD.GMT_END")
    public static final SqlColumn<Long> gmtEnd = ad.gmtEnd;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.848+08:00", comments="Source field: AD.STATUS")
    public static final SqlColumn<Integer> status = ad.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.848+08:00", comments="Source field: AD.POS")
    public static final SqlColumn<String> pos = ad.pos;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.847+08:00", comments="Source Table: AD")
    public static final class Ad extends SqlTable {
        public final SqlColumn<Integer> id = column("ID", JDBCType.INTEGER);

        public final SqlColumn<String> title = column("TITLE", JDBCType.VARCHAR);

        public final SqlColumn<String> url = column("URL", JDBCType.VARCHAR);

        public final SqlColumn<String> image = column("IMAGE", JDBCType.VARCHAR);

        public final SqlColumn<Long> gmtCreate = column("GMT_CREATE", JDBCType.BIGINT);

        public final SqlColumn<Long> gmtModify = column("GMT_MODIFY", JDBCType.BIGINT);

        public final SqlColumn<Long> gmtStart = column("GMT_START", JDBCType.BIGINT);

        public final SqlColumn<Long> gmtEnd = column("GMT_END", JDBCType.BIGINT);

        public final SqlColumn<Integer> status = column("STATUS", JDBCType.INTEGER);

        public final SqlColumn<String> pos = column("POS", JDBCType.VARCHAR);

        public Ad() {
            super("AD");
        }
    }
}