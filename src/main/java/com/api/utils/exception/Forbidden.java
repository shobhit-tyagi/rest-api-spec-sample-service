package com.api.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class Forbidden extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public Forbidden(final String msg) {
        super(msg);
    }

    public Forbidden(final String msg, final Throwable trbl) {
        super(msg, trbl);
    }
}
