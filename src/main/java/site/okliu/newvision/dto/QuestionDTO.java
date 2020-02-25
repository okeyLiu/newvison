package site.okliu.newvision.dto;

import lombok.Data;
import site.okliu.newvision.model.User;

@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModify;
    private Long creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
    private User user;
}
