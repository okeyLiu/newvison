package site.okliu.newvision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import site.okliu.newvision.dto.CommnetDTO;
import site.okliu.newvision.dto.ResultDTO;
import site.okliu.newvision.exception.CustomizeErrorCode;
import site.okliu.newvision.mapper.CommentMapper;
import site.okliu.newvision.model.Comment;
import site.okliu.newvision.model.User;
import site.okliu.newvision.service.CommentService;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @PostMapping("/comment")
    public Object post(@RequestBody CommnetDTO commnetDTO, HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user == null){
            return ResultDTO.errorOf(CustomizeErrorCode.NOT_LOGIN);
        }
        Comment comment = new Comment();
        comment.setParentId(commnetDTO.getParentId());
        comment.setContent(commnetDTO.getContent());
        comment.setType(commnetDTO.getType());
        comment.setCommentator(user.getId());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(comment.getGmtCreate());
        comment.setLikeCount(0L);
        commentService.insert(comment);
        return ResultDTO.okOf();
    }

}
