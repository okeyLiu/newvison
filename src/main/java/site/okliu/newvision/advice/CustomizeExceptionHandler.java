package site.okliu.newvision.advice;

import com.alibaba.fastjson.JSON;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import site.okliu.newvision.dto.ResultDTO;
import site.okliu.newvision.exception.CustomizeErrorCode;
import site.okliu.newvision.exception.CustomizeException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    String handle(Throwable ex, Model model, HttpServletRequest request, HttpServletResponse response) {
        String contentType = request.getContentType();
        if ("application/json".equals(contentType)) {
            // json
            ResultDTO resultDTO;
            if (ex instanceof CustomizeException) {
                resultDTO =  ResultDTO.errorOf((CustomizeException) ex);
            } else {
                resultDTO =  ResultDTO.errorOf(CustomizeErrorCode.SYSTEM_ERROR);
            }
            response.setContentType("application/json");
            response.setStatus(200);
            response.setCharacterEncoding("utf-8");
            try {
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException e) {
            }
            return null;
        } else {
            // 页面
            if (ex instanceof CustomizeException) {
                model.addAttribute("message", ex.getMessage());
            } else {
                model.addAttribute("message", CustomizeErrorCode.SYSTEM_ERROR.getMessage());
            }
            return "error";
        }
    }

}
