package site.okliu.newvision.advice;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import site.okliu.newvision.exception.CustomizeException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    String handle(HttpServletRequest request, Throwable ex, Model model) {
        ex.printStackTrace();
        HttpStatus status = getStatus(request);
        if(ex instanceof CustomizeException){
            model.addAttribute("message",((CustomizeException)ex).getMessage());
        }else{
            model.addAttribute("message","冒烟儿啦");
        }
        return "error";
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}
