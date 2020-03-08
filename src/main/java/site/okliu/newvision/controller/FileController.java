package site.okliu.newvision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import site.okliu.newvision.dto.FileDTO;
import site.okliu.newvision.utils.FileUtils;

@Controller
public class FileController {

    private final ResourceLoader resourceLoader;

    @Autowired
    public FileController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${web.upload-path}")
    private String path;

    @ResponseBody
    @RequestMapping("/file/upload")
    public FileDTO upload(@RequestParam(name = "editormd-image-file") MultipartFile file) throws Exception {
        FileDTO fileDTO = new FileDTO();
        if (file.isEmpty()) {
            fileDTO.setSuccess(0);
            fileDTO.setMessage("上传失败");
        } else {
            String fileName = file.getOriginalFilename();
            fileName = FileUtils.renameToUUID(fileName);
            FileUtils.uploadFiles(file.getBytes(), path, fileName);
            String url = "/show/" + fileName;
            fileDTO.setSuccess(1);
            fileDTO.setMessage("上传成功");
            fileDTO.setUrl(url);
        }
        return fileDTO;
    }

    @RequestMapping("/show/{fileName}")
    public ResponseEntity show(@PathVariable String fileName){
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
