package site.okliu.newvision.dto;

import lombok.Data;

@Data
public class CommnetCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
