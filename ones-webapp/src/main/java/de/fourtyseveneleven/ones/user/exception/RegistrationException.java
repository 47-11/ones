package de.fourtyseveneleven.ones.user.exception;

import de.fourtyseveneleven.ones.common.exception.OnesException;

import java.io.Serial;

public class RegistrationException extends OnesException {

    @Serial
    private static final long serialVersionUID = -109771423561630786L;

    public RegistrationException(String message) {
        super(message);
    }
}
