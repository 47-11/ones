package de.fourtyseveneleven.ones.model.exception;

import java.io.Serial;

public class RegistrationException extends OnesException {

    @Serial
    private static final long serialVersionUID = -109771423561630786L;

    public RegistrationException(String message) {
        super(message);
    }
}
