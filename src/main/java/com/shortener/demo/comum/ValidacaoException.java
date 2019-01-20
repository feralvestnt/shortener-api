package com.shortener.demo.comum;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidacaoException extends RuntimeException {

    public ValidacaoException(String exception) {
        super(exception);
    }
}