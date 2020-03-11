package site.okliu.newvision.model;

import javax.annotation.Generated;

public class Ad {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.845+08:00", comments="Source field: AD.ID")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.845+08:00", comments="Source field: AD.TITLE")
    private String title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.845+08:00", comments="Source field: AD.URL")
    private String url;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.846+08:00", comments="Source field: AD.IMAGE")
    private String image;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.846+08:00", comments="Source field: AD.GMT_CREATE")
    private Long gmtCreate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.846+08:00", comments="Source field: AD.GMT_MODIFY")
    private Long gmtModify;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.846+08:00", comments="Source field: AD.GMT_START")
    private Long gmtStart;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.847+08:00", comments="Source field: AD.GMT_END")
    private Long gmtEnd;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.847+08:00", comments="Source field: AD.STATUS")
    private Integer status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.847+08:00", comments="Source field: AD.POS")
    private String pos;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.845+08:00", comments="Source field: AD.ID")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.845+08:00", comments="Source field: AD.ID")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.845+08:00", comments="Source field: AD.TITLE")
    public String getTitle() {
        return title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.845+08:00", comments="Source field: AD.TITLE")
    public void setTitle(String title) {
        this.title = title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.846+08:00", comments="Source field: AD.URL")
    public String getUrl() {
        return url;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.846+08:00", comments="Source field: AD.URL")
    public void setUrl(String url) {
        this.url = url;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.846+08:00", comments="Source field: AD.IMAGE")
    public String getImage() {
        return image;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.846+08:00", comments="Source field: AD.IMAGE")
    public void setImage(String image) {
        this.image = image;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.846+08:00", comments="Source field: AD.GMT_CREATE")
    public Long getGmtCreate() {
        return gmtCreate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.846+08:00", comments="Source field: AD.GMT_CREATE")
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.846+08:00", comments="Source field: AD.GMT_MODIFY")
    public Long getGmtModify() {
        return gmtModify;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.846+08:00", comments="Source field: AD.GMT_MODIFY")
    public void setGmtModify(Long gmtModify) {
        this.gmtModify = gmtModify;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.846+08:00", comments="Source field: AD.GMT_START")
    public Long getGmtStart() {
        return gmtStart;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.846+08:00", comments="Source field: AD.GMT_START")
    public void setGmtStart(Long gmtStart) {
        this.gmtStart = gmtStart;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.847+08:00", comments="Source field: AD.GMT_END")
    public Long getGmtEnd() {
        return gmtEnd;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.847+08:00", comments="Source field: AD.GMT_END")
    public void setGmtEnd(Long gmtEnd) {
        this.gmtEnd = gmtEnd;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.847+08:00", comments="Source field: AD.STATUS")
    public Integer getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.847+08:00", comments="Source field: AD.STATUS")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.847+08:00", comments="Source field: AD.POS")
    public String getPos() {
        return pos;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-11T17:25:46.847+08:00", comments="Source field: AD.POS")
    public void setPos(String pos) {
        this.pos = pos;
    }
}