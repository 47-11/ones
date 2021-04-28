package de.fourtyseveneleven.ones.common.controller;

import de.fourtyseveneleven.ones.common.exception.ElementNotFoundException;
import de.fourtyseveneleven.ones.common.model.dto.ErrorDto;
import de.fourtyseveneleven.ones.common.exception.OnesException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import static de.fourtyseveneleven.ones.message.MessageUtils.getExceptionMessage;
import static java.util.Objects.isNull;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleUnknownException(Exception exception) {

        LOG.error("Handling exception", exception);

        return new ErrorDto(getExceptionMessage("common.internal-error"), exception.getMessage(), exception.getClass().getSimpleName());
    }

    @ExceptionHandler(ElementNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleElementNotFoundException(ElementNotFoundException e) {

        return new ErrorDto(e.getMessage(), e.getMessage(), e.getClass().getSimpleName());
    }

    @ExceptionHandler(OnesException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleOnesException(OnesException e) {

        final Throwable cause = e.getCause();
        final String exceptionMessage;
        final String exceptionType;
        if (isNull(cause)) {
            exceptionMessage = e.getMessage();
            exceptionType = e.getClass().getName();
        } else {
            exceptionMessage = cause.getMessage();
            exceptionType = cause.getClass().getName();

            if (cause instanceof OnesException) {
                LOG.debug("Handling OnesException", e);
            } else {
                LOG.error("Handling OnesException", e);
            }
        }

        return new ErrorDto(e.getMessage(), exceptionMessage,
                exceptionType);
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorDto handleAuthenticationException(
            Exception e) {

        return new ErrorDto(e.getMessage(), e.getMessage(),
                e.getClass().getName());
    }
}
