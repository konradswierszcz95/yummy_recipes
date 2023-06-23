package pl.konrad.swierszcz.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.konrad.swierszcz.exception.ApiError;
import pl.konrad.swierszcz.exception.reciepe.RecipeException;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
        RecipeException.class
    })
    public final ResponseEntity<ApiError> handleUnprocessableEntityException(Exception exception, WebRequest request) {
        var apiError = ApiError.aApiError()
                .withStatus(HttpStatus.UNPROCESSABLE_ENTITY)
                .withTimestamp(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC))
                .withMessage(exception.getMessage())
                .withDebugMessage(request.toString())
                .build();
        return new ResponseEntity<>(apiError, HttpStatusCode.valueOf(422));
    }
}
