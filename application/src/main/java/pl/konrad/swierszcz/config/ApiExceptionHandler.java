package pl.konrad.swierszcz.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.konrad.swierszcz.exception.ApiError;
import pl.konrad.swierszcz.exception.ApiException;
import pl.konrad.swierszcz.exception.UnexpectedErrorCodes;
import pl.konrad.swierszcz.exception.UnprocesableEntityApiException;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.stream.Collectors;

@Order(Ordered.HIGHEST_PRECEDENCE)
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

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        var body = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        body.put("code", UnexpectedErrorCodes.CONSTRAINT_VIOLATIONS.toString());
        body.put("message", UnexpectedErrorCodes.CONSTRAINT_VIOLATIONS.getMessage());
        return new ResponseEntity(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            Exception.class
    })
    public final ResponseEntity<ApiError> handleUnexpectedEntityException(Exception exception, WebRequest request) {
        var apiError = ApiError.aApiError()
                .withStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .withTimestamp(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC))
                .withCode(UnexpectedErrorCodes.UNEXPECTED_EXCEPTION.toString())
                .withMessage(UnexpectedErrorCodes.UNEXPECTED_EXCEPTION.getMessage())
                .withDebugMessage(request.toString())
                .build();
        return new ResponseEntity<>(apiError, HttpStatusCode.valueOf(500));
    }
}
