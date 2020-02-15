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
    private Long commentCount;
    private Long viewConunt;
    private Long likeCount;
    private String tag;
    private User user;
}
