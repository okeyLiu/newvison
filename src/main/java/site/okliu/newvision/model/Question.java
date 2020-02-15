package site.okliu.newvision.model;

import lombok.Data;

@Data
public class Question {

  private Long id;
  private String title;
  private String description;
  private Long gmtCreate;
  private Long gmtModify;
  private Long creator;
  private Long commentCount;
  private Long viewConunt;
  private Long likeCount;
  private String tag;

}
