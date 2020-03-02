package site.okliu.newvision.model;

import javax.annotation.Generated;

public class Notification {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.215+08:00", comments="Source field: NOTIFICATION.ID")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.215+08:00", comments="Source field: NOTIFICATION.NOTIFIER")
    private Long notifier;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.NOTIFIER_NAME")
    private String notifierName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.RECEIVER")
    private Long receiver;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.OUTER_ID")
    private Long outerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.OUTER_TITLE")
    private String outerTitle;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.TYPE")
    private Integer type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.GMT_CREATE")
    private Long gmtCreate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.STATUS")
    private Integer status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.215+08:00", comments="Source field: NOTIFICATION.ID")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.215+08:00", comments="Source field: NOTIFICATION.ID")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.215+08:00", comments="Source field: NOTIFICATION.NOTIFIER")
    public Long getNotifier() {
        return notifier;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.NOTIFIER")
    public void setNotifier(Long notifier) {
        this.notifier = notifier;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.NOTIFIER_NAME")
    public String getNotifierName() {
        return notifierName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.NOTIFIER_NAME")
    public void setNotifierName(String notifierName) {
        this.notifierName = notifierName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.RECEIVER")
    public Long getReceiver() {
        return receiver;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.RECEIVER")
    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.OUTER_ID")
    public Long getOuterId() {
        return outerId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.OUTER_ID")
    public void setOuterId(Long outerId) {
        this.outerId = outerId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.OUTER_TITLE")
    public String getOuterTitle() {
        return outerTitle;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.OUTER_TITLE")
    public void setOuterTitle(String outerTitle) {
        this.outerTitle = outerTitle;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.TYPE")
    public Integer getType() {
        return type;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.TYPE")
    public void setType(Integer type) {
        this.type = type;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.GMT_CREATE")
    public Long getGmtCreate() {
        return gmtCreate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.GMT_CREATE")
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.STATUS")
    public Integer getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-03-03T02:34:39.216+08:00", comments="Source field: NOTIFICATION.STATUS")
    public void setStatus(Integer status) {
        this.status = status;
    }
}