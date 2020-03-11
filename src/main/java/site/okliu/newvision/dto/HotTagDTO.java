package site.okliu.newvision.dto;

import lombok.Data;

import java.util.Objects;

@Data
public class HotTagDTO implements Comparable<HotTagDTO> {

    private String name;
    private Integer priority;
    private Integer questionCount;
    private Integer commentCount;
    private Integer likeCount;
    private Integer viewCount;

    @Override
    public int compareTo(HotTagDTO o) {
        return this.priority - o.priority;// 升序
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotTagDTO hotTagDTO = (HotTagDTO) o;
        return name.equals(hotTagDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
