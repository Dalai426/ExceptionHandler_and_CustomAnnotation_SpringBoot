package com.dalai.CustomAnnotations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;


@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value={ApiRequestException.class})
    public ResponseEntity<ApiException> handleApiRequestException(ApiRequestException e){

        HttpStatus badrequest=HttpStatus.BAD_REQUEST;

        ApiException apiException=new ApiException(e.getMessage(), HttpStatus.BAD_REQUEST,e.getCode(),ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<ApiException>(apiException,badrequest);
    }
}
