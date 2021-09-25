package com.example.restfulwebservice.user;

// 2XX -> OK
// 4XX -> Client
// 5XX -> Server

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Status 값을 어노테이션을 통해 추가할 수 있음
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
