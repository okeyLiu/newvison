package site.okliu.newvision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import site.okliu.newvision.dto.QuestionDTO;
import site.okliu.newvision.model.User;
import site.okliu.newvision.service.QuestionService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/{id}")
    public String question(@PathVariable("id") Integer id, Model model, HttpSession session) {
        QuestionDTO questionDTO = questionService.findById(id);
        model.addAttribute("question", questionDTO);
        User user = (User) session.getAttribute("user");
        Integer userId;
        if(user != null){
            userId = user.getId();// 登录用户
        }else{
            userId = -1;// 游客
        }
        questionService.updateViewCount(id,userId);
        return "question";
    }

}
