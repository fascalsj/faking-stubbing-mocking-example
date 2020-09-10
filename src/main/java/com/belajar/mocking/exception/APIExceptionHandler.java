package com.belajar.mocking.exception;

import com.belajar.mocking.response.ResponseFailed;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;


@Slf4j
@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(SQLGrammarException.class)
    public ResponseEntity<ResponseFailed> handleIllegalArgumentation(SQLGrammarException ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(500)
                .body(ResponseFailed.<ResponseFailed>builder()
                .status(500)
                .timestamp(new Date(System.currentTimeMillis()))
                .error(ex.getLocalizedMessage())
                .build());
    }

}

