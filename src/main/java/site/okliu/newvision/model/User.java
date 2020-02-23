package site.okliu.newvision.model;

import lombok.ToString;

import javax.annotation.Generated;

@ToString
public class User {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.381+08:00", comments="Source field: USER.ID")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.386+08:00", comments="Source field: USER.ACCOUNT_ID")
    private String accountId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.386+08:00", comments="Source field: USER.NAME")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.387+08:00", comments="Source field: USER.TOKEN")
    private String token;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.387+08:00", comments="Source field: USER.GMT_CREATE")
    private Long gmtCreate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.387+08:00", comments="Source field: USER.GMT_MODIFY")
    private Long gmtModify;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.387+08:00", comments="Source field: USER.BIO")
    private String bio;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.387+08:00", comments="Source field: USER.AVATAR_URL")
    private String avatarUrl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.385+08:00", comments="Source field: USER.ID")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.386+08:00", comments="Source field: USER.ID")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.386+08:00", comments="Source field: USER.ACCOUNT_ID")
    public String getAccountId() {
        return accountId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.386+08:00", comments="Source field: USER.ACCOUNT_ID")
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.386+08:00", comments="Source field: USER.NAME")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.387+08:00", comments="Source field: USER.NAME")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.387+08:00", comments="Source field: USER.TOKEN")
    public String getToken() {
        return token;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.387+08:00", comments="Source field: USER.TOKEN")
    public void setToken(String token) {
        this.token = token;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.387+08:00", comments="Source field: USER.GMT_CREATE")
    public Long getGmtCreate() {
        return gmtCreate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.387+08:00", comments="Source field: USER.GMT_CREATE")
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.387+08:00", comments="Source field: USER.GMT_MODIFY")
    public Long getGmtModify() {
        return gmtModify;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.387+08:00", comments="Source field: USER.GMT_MODIFY")
    public void setGmtModify(Long gmtModify) {
        this.gmtModify = gmtModify;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.387+08:00", comments="Source field: USER.BIO")
    public String getBio() {
        return bio;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.387+08:00", comments="Source field: USER.BIO")
    public void setBio(String bio) {
        this.bio = bio;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.387+08:00", comments="Source field: USER.AVATAR_URL")
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.387+08:00", comments="Source field: USER.AVATAR_URL")
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}