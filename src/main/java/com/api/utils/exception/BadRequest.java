package com.api.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequest extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BadRequest(final String msg) {
        super(msg);
    }
    public BadRequest(final String msg, final Throwable trbl) {
        super(msg, trbl);
    }
}
