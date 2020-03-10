package site.okliu.newvision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import site.okliu.newvision.dto.PaginationDTO;
import site.okliu.newvision.service.QuestionService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    private QuestionService questionService;

    @Autowired
    public IndexController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "size", defaultValue = "7") Integer size,
                        @RequestParam(value = "search", defaultValue = "", required = false) String search) {
        PaginationDTO pagination = questionService.list(search, page, size);
        model.addAttribute("pagination", pagination);
        model.addAttribute("search", search);
        return "index";
    }

}
