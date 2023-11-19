package com.dalai.CustomAnnotations.exception;

public class ApiRequestException extends RuntimeException{
    int code;
    public ApiRequestException(String message, int code){
        super(message);
        this.code=code;
    }
    public ApiRequestException(String message, Throwable cause, int code){
        super(message,cause);
        this.code=code;
    }

    public int getCode() {
        return code;
    }
}
