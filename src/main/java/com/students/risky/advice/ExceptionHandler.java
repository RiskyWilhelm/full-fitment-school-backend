package com.students.risky.advice;

import com.students.risky.advice.advices.AlreadyOccupiedException;
import com.students.risky.advice.advices.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Optional;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ExceptionResponseHandler> illegalException (Exception exception, WebRequest request){
        ExceptionResponseHandler exceptionResponseHandler = new ExceptionResponseHandler(LocalDateTime.now(), exception.getMessage(), "404");
        return new ResponseEntity<ExceptionResponseHandler>(exceptionResponseHandler, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(AlreadyOccupiedException.class)
    public final ResponseEntity<ExceptionResponseHandler> duplicateException (Exception exception, WebRequest request){
        ExceptionResponseHandler exceptionResponseHandler = new ExceptionResponseHandler(LocalDateTime.now(), exception.getMessage(), "500");
        return new ResponseEntity<ExceptionResponseHandler>(exceptionResponseHandler, HttpStatus.BAD_REQUEST);
    }
}
