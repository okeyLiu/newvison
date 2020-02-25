package site.okliu.newvision.dto;

import lombok.Data;

@Data
public class CommnetDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
