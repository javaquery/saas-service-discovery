package com.javaquery.sas.discovery.controller.rest.exception;

import com.javaquery.sas.discovery.controller.rest.response.CommonResponse;
import com.javaquery.util.collection.Collections;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vicky.thakor
 * @since 1.0.0
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers,
                                                                          HttpStatus status, WebRequest request) {
        String error = ex.getParameterName() + " parameter is missing.";
        return new ResponseEntity<>(CommonResponse.of(HttpStatus.BAD_REQUEST.value(), Collections.singletonList(error)), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        try {
            List<String> messages = new ArrayList<>();
            for(FieldError fieldError : ex.getBindingResult().getFieldErrors()){
                messages.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(CommonResponse.of(HttpStatus.BAD_REQUEST.value(), messages), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(CommonResponse.of(HttpStatus.BAD_REQUEST.value(), Collections.singletonList(ex.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Handle runtime exception exception response entity.
     *
     * @param ex      the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler({EntityNotFoundException.class, RuntimeException.class})
    protected ResponseEntity<?> handleRuntimeExceptionException(RuntimeException ex, HttpServletRequest request) {
        try {
            return new ResponseEntity<>(CommonResponse.of(HttpStatus.BAD_REQUEST.value(), Collections.singletonList(ex.getMessage())), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(CommonResponse.of(HttpStatus.BAD_REQUEST.value(), Collections.singletonList(ex.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

