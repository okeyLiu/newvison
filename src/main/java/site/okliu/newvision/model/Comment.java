package site.okliu.newvision.model;

import javax.annotation.Generated;

public class Comment {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.193+08:00", comments="Source field: COMMENT.ID")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.193+08:00", comments="Source field: COMMENT.PARENT_ID")
    private Long parentId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.193+08:00", comments="Source field: COMMENT.TYPE")
    private Integer type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.194+08:00", comments="Source field: COMMENT.COMMENTATOR")
    private Long commentator;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.194+08:00", comments="Source field: COMMENT.GMT_CREATE")
    private Long gmtCreate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.194+08:00", comments="Source field: COMMENT.GMT_MODIFIED")
    private Long gmtModified;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.194+08:00", comments="Source field: COMMENT.LIKE_COUNT")
    private Long likeCount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.194+08:00", comments="Source field: COMMENT.CONTENT")
    private String content;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.193+08:00", comments="Source field: COMMENT.ID")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.193+08:00", comments="Source field: COMMENT.ID")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.193+08:00", comments="Source field: COMMENT.PARENT_ID")
    public Long getParentId() {
        return parentId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.193+08:00", comments="Source field: COMMENT.PARENT_ID")
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.193+08:00", comments="Source field: COMMENT.TYPE")
    public Integer getType() {
        return type;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.194+08:00", comments="Source field: COMMENT.TYPE")
    public void setType(Integer type) {
        this.type = type;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.194+08:00", comments="Source field: COMMENT.COMMENTATOR")
    public Long getCommentator() {
        return commentator;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.194+08:00", comments="Source field: COMMENT.COMMENTATOR")
    public void setCommentator(Long commentator) {
        this.commentator = commentator;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.194+08:00", comments="Source field: COMMENT.GMT_CREATE")
    public Long getGmtCreate() {
        return gmtCreate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.194+08:00", comments="Source field: COMMENT.GMT_CREATE")
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.194+08:00", comments="Source field: COMMENT.GMT_MODIFIED")
    public Long getGmtModified() {
        return gmtModified;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.194+08:00", comments="Source field: COMMENT.GMT_MODIFIED")
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.194+08:00", comments="Source field: COMMENT.LIKE_COUNT")
    public Long getLikeCount() {
        return likeCount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.194+08:00", comments="Source field: COMMENT.LIKE_COUNT")
    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.194+08:00", comments="Source field: COMMENT.CONTENT")
    public String getContent() {
        return content;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-26T01:10:29.194+08:00", comments="Source field: COMMENT.CONTENT")
    public void setContent(String content) {
        this.content = content;
    }
}