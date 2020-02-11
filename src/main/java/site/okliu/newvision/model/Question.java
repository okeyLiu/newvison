package site.okliu.newvision.model;


public class Question {

  private long id;
  private String title;
  private String description;
  private long gmtCreate;
  private long gmtModify;
  private long creator;
  private long commentCount;
  private long viewConunt;
  private long likeCount;
  private String tag;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public long getGmtCreate() {
    return gmtCreate;
  }

  public void setGmtCreate(long gmtCreate) {
    this.gmtCreate = gmtCreate;
  }


  public long getGmtModify() {
    return gmtModify;
  }

  public void setGmtModify(long gmtModify) {
    this.gmtModify = gmtModify;
  }


  public long getCreator() {
    return creator;
  }

  public void setCreator(long creator) {
    this.creator = creator;
  }


  public long getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(long commentCount) {
    this.commentCount = commentCount;
  }


  public long getViewConunt() {
    return viewConunt;
  }

  public void setViewConunt(long viewConunt) {
    this.viewConunt = viewConunt;
  }


  public long getLikeCount() {
    return likeCount;
  }

  public void setLikeCount(long likeCount) {
    this.likeCount = likeCount;
  }


  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

}
