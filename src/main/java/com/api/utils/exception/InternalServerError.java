package com.api.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerError extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InternalServerError(final String msg) {
        super(msg);
    }

    public InternalServerError(final String msg, final Throwable trbl) {
        super(msg, trbl);
    }
}
