package com.app.vetcare.exception;



import com.app.vetcare.config.APIErrorCodeConfig;
import com.app.vetcare.model.error.APIRequestErrorModel;
import com.app.vetcare.model.error.ErrorSeverityLevelCodeType;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * This is the custom exception handler class
 */
@ControllerAdvice
@RestController
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }

        return new ResponseEntity(body, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        UUID uuid = UUID.randomUUID();
        log.error(ex.getMessage());
        final APIRequestErrorModel error = new APIRequestErrorModel(errors, APIErrorCodeConfig.INVALID_INPUT, ErrorSeverityLevelCodeType.ERROR,uuid);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(UserException.class)
    @ResponseBody
    public ResponseEntity<Object> handleUserException(UserException ex) {
        UUID uuid = UUID.randomUUID();
        log.error(String.valueOf(ex.getMessage()));
        HttpStatus status = ex.getStatus() == null ? HttpStatus.BAD_REQUEST : ex.getStatus();
        final APIRequestErrorModel error = new APIRequestErrorModel(ex.getMessage(), APIErrorCodeConfig.INVALID_INPUT, ErrorSeverityLevelCodeType.ERROR,uuid);
        return new ResponseEntity<>(error, status);
    }




    @ExceptionHandler({IllegalArgumentException.class, InvalidDataAccessApiUsageException.class})
    @ResponseBody
    public ResponseEntity<Object> handleArgumentException(Exception ex) {
        UUID uuid = UUID.randomUUID();
        log.error(String.valueOf(ex.getMessage()));
        final APIRequestErrorModel error = new APIRequestErrorModel(ex.getMessage(), APIErrorCodeConfig.INVALID_INPUT, ErrorSeverityLevelCodeType.ERROR,uuid);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        UUID uuid = UUID.randomUUID();
        log.error(String.valueOf(ex.getMessage()));
        String message = ex.getMessage();
        if (ex.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
            message = APIErrorCodeConfig.DB_ERROR;
        }

        final APIRequestErrorModel error = new APIRequestErrorModel(message, APIErrorCodeConfig.DB_ERROR, ErrorSeverityLevelCodeType.ERROR,uuid);
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public final ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        UUID uuid = UUID.randomUUID();
        log.error(String.valueOf(ex.getMessage()));
        final APIRequestErrorModel error = new APIRequestErrorModel(ex.getMessage(), APIErrorCodeConfig.DB_ERROR, ErrorSeverityLevelCodeType.ERROR,uuid);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
        UUID uuid = UUID.randomUUID();
        log.error(String.valueOf(ex.getMessage()));
        final APIRequestErrorModel error = new APIRequestErrorModel(ex.getMessage(), APIErrorCodeConfig.INTERNAL_ERROR, ErrorSeverityLevelCodeType.ERROR,uuid);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Object> handleGlobalException(Exception ex) {
        UUID uuid = UUID.randomUUID();
        log.error(String.valueOf(ex.getMessage()));
        final APIRequestErrorModel error = new APIRequestErrorModel(ex.getMessage(), APIErrorCodeConfig.GLOBAL_ERROR, ErrorSeverityLevelCodeType.ERROR,uuid);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
