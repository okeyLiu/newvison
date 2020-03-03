package site.okliu.newvision.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.okliu.newvision.dto.FileDTO;

@Controller
public class FileController {

    @ResponseBody
    @RequestMapping("/file/upload")
    public FileDTO upload(){
        FileDTO fileDTO = new FileDTO();
        fileDTO.setSuccess(1);
        fileDTO.setMessage("上传成功");
        fileDTO.setUrl("/images/icon-25.jpg");
        return fileDTO;
    }

}
