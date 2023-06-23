package pl.konrad.swierszcz.exception.reciepe;

public class RecipeException extends RuntimeException {
    public RecipeException(String message) {
        super(message);
    }

    public RecipeException(String message, Throwable cause) {
        super(message, cause);
    }
}
