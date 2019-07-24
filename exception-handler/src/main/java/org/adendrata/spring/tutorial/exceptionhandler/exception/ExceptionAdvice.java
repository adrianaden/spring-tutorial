package org.adendrata.spring.tutorial.exceptionhandler.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    ResponseEntity<ResponseFailure> exception(Exception e) {
        String message = e.getMessage();
        List<String> errors = Collections.singletonList(e.getMessage());

        return ResponseEntity.badRequest().body(ResponseFailure.builder()
                .timestamp(System.currentTimeMillis())
                .result("FAILURE")
                .message(message)
                .errors(errors)
                .build()
        );
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ResponseFailure> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        String message = "Arguments not Valid";
        List<String> errors = e.getBindingResult().getFieldErrors().stream()
                .map(x -> x.getField() + " " + x.getDefaultMessage())
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(ResponseFailure.builder()
                .timestamp(System.currentTimeMillis())
                .result("FAILURE")
                .message(message)
                .errors(errors)
                .build()
        );
    }
}
