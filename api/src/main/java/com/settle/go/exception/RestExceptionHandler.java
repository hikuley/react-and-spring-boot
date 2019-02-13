package com.settle.go.exception;

import com.settle.go.model.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class RestExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(BaseException.class)
    public BaseResponse baseExceptionHandler(BaseException ex) {

        log.error("An error occurred at the REST API", ex);

        return new BaseResponse.Builder()
                .withSuccess(false)
                .withResponseMessage(ex.getMessage())
                .withTimestamp(System.currentTimeMillis())
                .build();
    }


}
