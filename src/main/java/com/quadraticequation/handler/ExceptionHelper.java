package com.quadraticequation.handler;

import com.quadraticequation.exception.CalculateException;
import com.quadraticequation.model.dto.ExceptionMessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class ExceptionHelper {
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandler.class);

    @ExceptionHandler(value = { RuntimeException.class })
    public ResponseEntity<ExceptionMessageResponse> handleInvalidInputException(RuntimeException ex) {

        LOG.error("Invalid Input Exception: {}", ex.getMessage());

        return new ResponseEntity<>(new ExceptionMessageResponse("failed",ex.getMessage(),
                LocalDateTime.now()), BAD_REQUEST);
    }
    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseEntity<ExceptionMessageResponse> handleInvalidInputException(MethodArgumentNotValidException ex) {

        LOG.error("Invalid Input Exception: {}", ex.getMessage());

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(new ExceptionMessageResponse("failed", errors.toString(),
                LocalDateTime.now()), BAD_REQUEST);
    }
    @ExceptionHandler(value = { HttpMessageNotReadableException.class })
    public ResponseEntity<ExceptionMessageResponse> handleInvalidFormatException(HttpMessageNotReadableException ex) {

        LOG.error("Invalid Format Exception: {}", ex.getMessage());

        return new ResponseEntity<>(new ExceptionMessageResponse("failed","Передали неверный формат данных, введите 3 числа",
                LocalDateTime.now()), OK);
    }

    @ExceptionHandler(value = { CalculateException.class })
    public ResponseEntity<ExceptionMessageResponse> handleInvalidCalculateException(CalculateException ex) {

        LOG.error("Calculate result exception: {}", ex.getMessage());

        return new ResponseEntity<>(new ExceptionMessageResponse("failed",ex.getMessage(),
                LocalDateTime.now()), OK);
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<ExceptionMessageResponse> handleException(Exception ex) {

        LOG.error("Exception: {}", ex.getMessage());

        return new ResponseEntity<>(new ExceptionMessageResponse("failed",ex.getMessage(),
                LocalDateTime.now()), INTERNAL_SERVER_ERROR);
    }
}
