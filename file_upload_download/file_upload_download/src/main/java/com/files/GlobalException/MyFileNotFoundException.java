package com.files.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyFileNotFoundException extends RuntimeException{

    public MyFileNotFoundException(String message){
        super(message);
    }

    public MyFileNotFoundException(String message, Throwable error){
        super(message,error);
    }
}
