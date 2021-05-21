package de.fourtyseveneleven.ones.security.exception;

import org.springframework.security.core.AuthenticationException;

import java.io.Serial;

public class InvalidAuthenticationException extends AuthenticationException {

    @Serial
    private static final long serialVersionUID = 4206806674238172273L;

    public InvalidAuthenticationException(String msg) {
        super(msg);
    }
}
