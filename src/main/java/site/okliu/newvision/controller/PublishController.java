package site.okliu.newvision.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import site.okliu.newvision.cache.TagCache;
import site.okliu.newvision.dto.QuestionDTO;
import site.okliu.newvision.model.Question;
import site.okliu.newvision.model.User;
import site.okliu.newvision.service.QuestionService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/publish")
public class PublishController {

    private QuestionService questionService;

    @Autowired
    public PublishController(QuestionService questionService) {
        assert questionService != null;
        this.questionService = questionService;
    }

    @GetMapping("")
    public String publish(Model model) {
        model.addAttribute("tags", TagCache.get());
        return "publish";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        QuestionDTO question = questionService.findById(id);
        model.addAttribute("title", question.getTitle());
        model.addAttribute("description", question.getDescription());
        model.addAttribute("tag", question.getTag());
        model.addAttribute("id", question.getId());
        model.addAttribute("tags", TagCache.get());
        return "publish";
    }

    @PostMapping("")
    public String doPublish(@RequestParam(value = "title", required = false) String title,
                            @RequestParam(value = "description", required = false) String description,
                            @RequestParam(value = "tag", required = false) String tag,
                            @RequestParam(value = "id", required = false) Long id,
                            HttpSession session,
                            Model model) {
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);
        model.addAttribute("tags", TagCache.get());

        if (title == null || title == "") {
            model.addAttribute("error", "问题标题不能为空");
            return "publish";
        }
        if (description == null || description == "") {
            model.addAttribute("error", "问题补充不能为空");
            return "publish";
        }
        if (tag == null || tag == "") {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }
        String invalidTag = TagCache.invalidTag(tag);
        if(StringUtils.isNotBlank(invalidTag)){
            model.addAttribute("error", "不能使用非法标签："+invalidTag);
            return "publish";
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setId(id);
        questionService.createOrUpdate(question);
        return "redirect:/profile/questions";
    }

}
