package site.okliu.newvision.model;

import lombok.Data;

@Data
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

}
