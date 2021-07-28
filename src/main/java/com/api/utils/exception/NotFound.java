package com.api.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFound extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotFound(final String msg) {
        super(msg);
    }

    public NotFound(final String msg, final Throwable trbl) {
        super(msg, trbl);
    }
}
