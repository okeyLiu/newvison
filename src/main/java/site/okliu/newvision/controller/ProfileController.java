package site.okliu.newvision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import site.okliu.newvision.dto.PaginationDTO;
import site.okliu.newvision.model.User;
import site.okliu.newvision.service.NotificationService;
import site.okliu.newvision.service.QuestionService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/{action}")
    public String profile(
            @PathVariable String action,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "5") Integer size,
            HttpSession session,
            Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        PaginationDTO pagination = null;
        switch (action) {
            case "questions":
                model.addAttribute("section", "questions");
                model.addAttribute("sectionName", "我的提问");
                pagination = questionService.list(user.getId(), page, size);
                model.addAttribute("pagination",pagination);
                break;
            case "replies":
                model.addAttribute("section", "replies");
                model.addAttribute("sectionName", "最新回复");
                pagination = notificationService.list(user.getId(), page, size);
                model.addAttribute("pagination",pagination);
                break;
        }
        return "profile";
    }

}
