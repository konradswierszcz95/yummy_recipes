package pl.konrad.swierszcz.exception;

public enum UnexpectedErrorCodes {
    UNEXPECTED_EXCEPTION("Unexpected exception. Please contact website administartor"),
    CONSTRAINT_VIOLATIONS("Request is incorrect. Please fix it before reprocessing");

    private final String message;

    UnexpectedErrorCodes(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
