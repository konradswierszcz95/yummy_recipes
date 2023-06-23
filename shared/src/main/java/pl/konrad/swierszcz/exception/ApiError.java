package pl.konrad.swierszcz.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor(staticName = "of")
@Getter
@Builder(builderMethodName = "aApiError", setterPrefix = "with", toBuilder = true)
public class ApiError {
    private final HttpStatus status;
    private final long timestamp;
    private final String message;
    private final String debugMessage;
}
