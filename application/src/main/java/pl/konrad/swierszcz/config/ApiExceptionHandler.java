package pl.konrad.swierszcz.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.konrad.swierszcz.exception.ApiError;
import pl.konrad.swierszcz.exception.ApiException;
import pl.konrad.swierszcz.exception.UnprocesableEntityApiException;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
        UnprocesableEntityApiException.class
    })
    public final ResponseEntity<ApiError> handleUnprocessableEntityException(ApiException exception, WebRequest request) {
        var apiError = ApiError.aApiError()
                .withStatus(HttpStatus.UNPROCESSABLE_ENTITY)
                .withTimestamp(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC))
                .withCode(exception.getCode())
                .withMessage(exception.getMessage())
                .withDebugMessage(request.toString())
                .build();
        return new ResponseEntity<>(apiError, HttpStatusCode.valueOf(422));
    }

    @ExceptionHandler({
            Exception.class
    })
    public final ResponseEntity<ApiError> handleUnprocessableEntityException(Exception exception, WebRequest request) {
        var apiError = ApiError.aApiError()
                .withStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .withTimestamp(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC))
                .withCode("UNEXPECTED_EXCEPTION")
                .withMessage("Unexpected exception. Please contact website administartor")
                .withDebugMessage(request.toString())
                .build();
        return new ResponseEntity<>(apiError, HttpStatusCode.valueOf(500));
    }
}
