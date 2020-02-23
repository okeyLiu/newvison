package site.okliu.newvision.model;

import lombok.ToString;

import javax.annotation.Generated;

@ToString
public class Question {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.419+08:00", comments="Source field: QUESTION.ID")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.419+08:00", comments="Source field: QUESTION.TITLE")
    private String title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.419+08:00", comments="Source field: QUESTION.GMT_CREATE")
    private Long gmtCreate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.419+08:00", comments="Source field: QUESTION.GMT_MODIFY")
    private Long gmtModify;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.419+08:00", comments="Source field: QUESTION.CREATOR")
    private Integer creator;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.42+08:00", comments="Source field: QUESTION.COMMENT_COUNT")
    private Integer commentCount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.42+08:00", comments="Source field: QUESTION.VIEW_COUNT")
    private Integer viewCount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.42+08:00", comments="Source field: QUESTION.LIKE_COUNT")
    private Integer likeCount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.42+08:00", comments="Source field: QUESTION.TAG")
    private String tag;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.42+08:00", comments="Source field: QUESTION.DESCRIPTION")
    private String description;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.419+08:00", comments="Source field: QUESTION.ID")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.419+08:00", comments="Source field: QUESTION.ID")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.419+08:00", comments="Source field: QUESTION.TITLE")
    public String getTitle() {
        return title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.419+08:00", comments="Source field: QUESTION.TITLE")
    public void setTitle(String title) {
        this.title = title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.419+08:00", comments="Source field: QUESTION.GMT_CREATE")
    public Long getGmtCreate() {
        return gmtCreate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.419+08:00", comments="Source field: QUESTION.GMT_CREATE")
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.419+08:00", comments="Source field: QUESTION.GMT_MODIFY")
    public Long getGmtModify() {
        return gmtModify;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.419+08:00", comments="Source field: QUESTION.GMT_MODIFY")
    public void setGmtModify(Long gmtModify) {
        this.gmtModify = gmtModify;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.42+08:00", comments="Source field: QUESTION.CREATOR")
    public Integer getCreator() {
        return creator;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.42+08:00", comments="Source field: QUESTION.CREATOR")
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.42+08:00", comments="Source field: QUESTION.COMMENT_COUNT")
    public Integer getCommentCount() {
        return commentCount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.42+08:00", comments="Source field: QUESTION.COMMENT_COUNT")
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.42+08:00", comments="Source field: QUESTION.VIEW_COUNT")
    public Integer getViewCount() {
        return viewCount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.42+08:00", comments="Source field: QUESTION.VIEW_COUNT")
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.42+08:00", comments="Source field: QUESTION.LIKE_COUNT")
    public Integer getLikeCount() {
        return likeCount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.42+08:00", comments="Source field: QUESTION.LIKE_COUNT")
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.42+08:00", comments="Source field: QUESTION.TAG")
    public String getTag() {
        return tag;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.42+08:00", comments="Source field: QUESTION.TAG")
    public void setTag(String tag) {
        this.tag = tag;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.42+08:00", comments="Source field: QUESTION.DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-24T01:15:15.42+08:00", comments="Source field: QUESTION.DESCRIPTION")
    public void setDescription(String description) {
        this.description = description;
    }
}