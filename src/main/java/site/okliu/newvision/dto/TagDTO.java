package site.okliu.newvision.dto;

import lombok.Data;

import java.util.List;

@Data
public class TagDTO {
    private String categroyName;
    private List<String> tags;
}
