package site.okliu.newvision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import site.okliu.newvision.cache.HotTagCache;
import site.okliu.newvision.dto.PaginationDTO;
import site.okliu.newvision.service.QuestionService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    private QuestionService questionService;
    private HotTagCache hotTagCache;

    @Autowired
    public IndexController(QuestionService questionService, HotTagCache hotTagCache) {
        this.questionService = questionService;
        this.hotTagCache = hotTagCache;
    }

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "size", defaultValue = "7") Integer size,
                        @RequestParam(value = "search", defaultValue = "", required = false) String search,
                        @RequestParam(value = "tag", defaultValue = "", required = false) String tag
    ) {
        PaginationDTO pagination = questionService.list(search, tag, page, size);
        model.addAttribute("pagination", pagination);
        model.addAttribute("search", search);
        model.addAttribute("tags", hotTagCache.getHots());
        model.addAttribute("tag", tag);
        return "index";
    }

}
