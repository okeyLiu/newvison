package site.okliu.newvision.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showLastPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPages;
    private Integer size;

    public void setPaginationDTO(int count, Integer page, Integer size) {
        this.page = page;
        this.size = size;
        // 计算总页数
        if (count % size == 0) {
            totalPages = count / size;
        } else {
            totalPages = count / size + 1;
        }
        // 优化参数
        if(page<1){
            page = 1;
        }
        if(page > totalPages){
            page = totalPages;
        }
        // 显示的页码
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPages) {
                pages.add(page + i);
            }
        }
        // 是否显示上一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        // 是否显示下一页
        if (page == totalPages) {
            showNext = false;
        } else {
            showNext = true;
        }
        // 是否显示第一页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }
        // 是否显示最后一页
        if (pages.contains(totalPages)) {
            showLastPage = false;
        } else {
            showLastPage = true;
        }
    }
}
