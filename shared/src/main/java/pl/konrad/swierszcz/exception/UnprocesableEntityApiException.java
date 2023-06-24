package pl.konrad.swierszcz.exception;

public class UnprocesableEntityApiException extends ApiException {
    public UnprocesableEntityApiException(String message, String code) {
        super(message, code);
    }

    public UnprocesableEntityApiException(String message, String code, Throwable cause) {
        super(message, code, cause);
    }
}
