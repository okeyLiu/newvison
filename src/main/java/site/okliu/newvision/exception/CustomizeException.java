package site.okliu.newvision.exception;

public class CustomizeException extends RuntimeException {
    private Integer code;
    private String message;

    public CustomizeException(Integer code,String message) {
        this.code = code;
        this.message = message;
    }

    public CustomizeException(ICustomizeErrorCode iCoustomzeErrorCode) {
        this.code = iCoustomzeErrorCode.getCode();
        this.message = iCoustomzeErrorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
