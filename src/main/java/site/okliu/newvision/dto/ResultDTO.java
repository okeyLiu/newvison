package site.okliu.newvision.dto;

import lombok.Data;
import site.okliu.newvision.exception.CustomizeErrorCode;
import site.okliu.newvision.exception.CustomizeException;

@Data
public class ResultDTO<T> {

    private Integer code;
    private String message;
    private T data;

    public static ResultDTO errorOf(Integer code, String message){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.code = code;
        resultDTO.message = message;
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomizeErrorCode errorCode){
        return errorOf(errorCode.getCode(),errorCode.getMessage());
    }

    public static ResultDTO errorOf(CustomizeException e){
        return errorOf(e.getCode(),e.getMessage());
    }

    public static ResultDTO okOf(){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.code = 200;
        resultDTO.message = "请求成功";
        return resultDTO;
    }

    public static <T> ResultDTO okOf(T t){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.code = 200;
        resultDTO.message = "请求成功";
        resultDTO.data = t;
        return resultDTO;
    }
}
