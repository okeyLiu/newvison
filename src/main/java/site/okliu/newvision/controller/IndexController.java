package site.okliu.newvision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import site.okliu.newvision.dto.QuestionDTO;
import site.okliu.newvision.mapper.UserMapper;
import site.okliu.newvision.service.QuestionService;
import site.okliu.newvision.provider.CookieProvider;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model){
        CookieProvider.getUserAndPutInSessionFromCookies(request,userMapper);
        List<QuestionDTO> questionDTOList = questionService.list();
        model.addAttribute("questions",questionDTOList);
        return "index";
    }



}
