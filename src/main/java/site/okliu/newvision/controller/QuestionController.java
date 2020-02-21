package site.okliu.newvision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import site.okliu.newvision.dto.QuestionDTO;
import site.okliu.newvision.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/{id}")
    public String question(@PathVariable("id") Long id, Model model) {
        QuestionDTO questionDTO = questionService.findById(id);
        model.addAttribute("question", questionDTO);
        return "question";
    }

}
