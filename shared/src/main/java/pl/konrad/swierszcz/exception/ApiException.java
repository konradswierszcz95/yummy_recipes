package pl.konrad.swierszcz.exception;

public class ApiException extends RuntimeException {
    private final String code;

    public ApiException(String message, String code) {
        super(message);
        this.code = code;
    }

    public ApiException(String message, String code, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
