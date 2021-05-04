package de.fourtyseveneleven.ones.user.exception;

import org.springframework.security.authentication.AccountStatusException;

import java.io.Serial;

public class RegistrationIncompleteException extends AccountStatusException {

    @Serial
    private static final long serialVersionUID = -2170915674723861386L;

    public RegistrationIncompleteException(String msg) {
        super(msg);
    }
}
