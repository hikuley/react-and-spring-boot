package com.settle.go.exception;

import java.io.Serializable;

public class BaseException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

}