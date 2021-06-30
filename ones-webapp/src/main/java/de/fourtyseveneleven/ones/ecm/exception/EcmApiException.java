package de.fourtyseveneleven.ones.ecm.exception;

import de.fourtyseveneleven.ones.common.exception.OnesException;

import java.io.Serial;

public class EcmApiException extends OnesException {

    @Serial
    private static final long serialVersionUID = -5337622192945826330L;

    public EcmApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
