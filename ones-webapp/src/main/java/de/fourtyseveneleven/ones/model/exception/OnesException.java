package de.fourtyseveneleven.ones.model.exception;

import java.io.Serial;

public class OnesException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 3933385235628563531L;

    public OnesException(String message) {
        super(message);
    }
}
