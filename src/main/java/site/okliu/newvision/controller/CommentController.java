package site.okliu.newvision.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import site.okliu.newvision.dto.CommentDTO;
import site.okliu.newvision.dto.CommnetCreateDTO;
import site.okliu.newvision.dto.ResultDTO;
import site.okliu.newvision.enums.CommentTypeEnum;
import site.okliu.newvision.exception.CustomizeErrorCode;
import site.okliu.newvision.model.Comment;
import site.okliu.newvision.model.User;
import site.okliu.newvision.service.CommentService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @PostMapping("/comment")
    public ResultDTO post(@RequestBody CommnetCreateDTO commnetCreateDTO, HttpSession session) {
        System.out.println("commnetCreateDTO = " + commnetCreateDTO);
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResultDTO.errorOf(CustomizeErrorCode.NOT_LOGIN);
        }
        if (commnetCreateDTO.getContent() == null || StringUtils.isBlank(commnetCreateDTO.getContent())) {
            return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }
        if (commnetCreateDTO.getParentId() == null || commnetCreateDTO.getParentId() == 0) {
            return ResultDTO.errorOf(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if (commnetCreateDTO.getType() == null || !CommentTypeEnum.isExists(commnetCreateDTO.getType())) {
            return ResultDTO.errorOf(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        Comment comment = new Comment();
        comment.setParentId(commnetCreateDTO.getParentId());
        comment.setContent(commnetCreateDTO.getContent());
        comment.setType(commnetCreateDTO.getType());
        comment.setCommentator(user.getId());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(comment.getGmtCreate());
        comment.setLikeCount(0L);
        commentService.insert(comment);
        return ResultDTO.okOf();
    }

    @ResponseBody
    @GetMapping("/comment/{id}")
    public ResultDTO<List<CommentDTO>> comments(@PathVariable("id") Long id) {
        List<CommentDTO> commentDTOS = commentService.listByTargetId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }

}
