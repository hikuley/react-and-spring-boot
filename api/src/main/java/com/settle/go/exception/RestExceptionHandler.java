package com.settle.go.exception;

import com.settle.go.model.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public BaseResponse baseExceptionHandler(BaseException ex) {
        return new BaseResponse.Builder()
                .withSuccess(false)
                .withResponseMessage(ex.getMessage())
                .withTimestamp(System.currentTimeMillis())
                .build();
    }


}
