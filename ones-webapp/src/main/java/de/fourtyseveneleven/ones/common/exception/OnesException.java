package de.fourtyseveneleven.ones.common.exception;

import java.io.Serial;

public class OnesException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 3933385235628563531L;

    public OnesException() {}

    public OnesException(String message) {
        super(message);
    }

    public OnesException(String message, Throwable cause) {
        super(message, cause);
    }
}
