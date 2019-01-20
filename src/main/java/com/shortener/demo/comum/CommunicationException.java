package com.shortener.demo.comum;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class CommunicationException extends RuntimeException {

    public CommunicationException(String exception) {
        super(exception);
    }
}
