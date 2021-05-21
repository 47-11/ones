package de.fourtyseveneleven.ones.user.exception;

import de.fourtyseveneleven.ones.common.exception.OnesException;

import java.io.Serial;

public class ForgotPasswordException extends OnesException {

    @Serial
    private static final long serialVersionUID = 7224671635034903910L;

    public ForgotPasswordException(String message) {
        super(message);
    }
}
