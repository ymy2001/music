package com.music.exception;

import com.music.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GloableException {
    @ExceptionHandler(Exception.class)
    public Result ex(Exception e){
        e.printStackTrace();
        return Result.error("ERROR");
    }
}
