package site.okliu.newvision.exception;

public class CustomizeException extends RuntimeException {

    private String message;

    public CustomizeException(String message) {
        this.message = message;
    }

    public CustomizeException(ICustomizeErrorCode iCoustomzeErrorCode) {
        this.message = iCoustomzeErrorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
