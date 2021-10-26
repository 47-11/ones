package de.fourtyseveneleven.ones.ecm.exception;

import de.fourtyseveneleven.ones.common.exception.OnesException;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;

import java.io.Serial;

public class EcmApiException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -1019768785669200482L;

    private final ApiException cause;

    public EcmApiException(ApiException cause) {
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        return cause.getMessage();
    }

    @Override
    public ApiException getCause() {
        return cause;
    }
}
