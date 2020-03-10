package site.okliu.newvision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import site.okliu.newvision.dto.CommentDTO;
import site.okliu.newvision.dto.QuestionDTO;
import site.okliu.newvision.enums.CommentTypeEnum;
import site.okliu.newvision.service.CommentService;
import site.okliu.newvision.service.QuestionService;

import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {
    private QuestionService questionService;
    private CommentService commentService;

    @Autowired
    public QuestionController(QuestionService questionService, CommentService commentService) {
        this.questionService = questionService;
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public String question(@PathVariable("id") Long id, Model model) {
        QuestionDTO questionDTO = questionService.findById(id);
        List<QuestionDTO> relatedQuestinDTOs = questionService.findRelated(questionDTO);
        List<CommentDTO> comments = commentService.listByTargetId(id, CommentTypeEnum.QUESTION);
        model.addAttribute("question", questionDTO);
        model.addAttribute("relatedQuestions", relatedQuestinDTOs);
        model.addAttribute("comments", comments);
        questionService.incViewCount(id);
        return "question";
    }

}
