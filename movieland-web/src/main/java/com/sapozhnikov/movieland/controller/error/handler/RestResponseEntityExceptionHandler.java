package com.sapozhnikov.movieland.controller.error.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler (value = {IllegalArgumentException.class, MethodArgumentTypeMismatchException.class})
    protected ResponseEntity<Object> handleIlligalRequestParams(Exception e) {
      logger.error("Incorrect request params: {} ", e.getLocalizedMessage());
      return ResponseEntity.badRequest().build();
    }
}
