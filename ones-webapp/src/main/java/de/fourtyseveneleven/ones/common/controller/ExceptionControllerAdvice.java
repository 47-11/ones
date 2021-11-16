package de.fourtyseveneleven.ones.common.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.fourtyseveneleven.ones.common.exception.ElementNotFoundException;
import de.fourtyseveneleven.ones.common.model.dto.ErrorDto;
import de.fourtyseveneleven.ones.common.exception.OnesException;
import de.fourtyseveneleven.ones.ecm.exception.EcmApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.model.EcmErrorResponse;
import de.fourtyseveneleven.ones.message.MessageUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import java.util.Optional;

import static de.fourtyseveneleven.ones.message.MessageUtils.getExceptionMessage;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.joining;
import static org.apache.commons.lang3.StringUtils.isBlank;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    private final ObjectMapper objectMapper;

    public ExceptionControllerAdvice(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

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
            exceptionType = e.getClass().getSimpleName();
        } else {
            exceptionMessage = cause.getMessage();
            exceptionType = cause.getClass().getSimpleName();

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
                e.getClass().getSimpleName());
    }

    @ExceptionHandler({TransactionSystemException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleTransactionSystemException(TransactionSystemException e) {

        final Throwable rootCause = e.getRootCause();
        if (rootCause instanceof ConstraintViolationException constraintViolationException) {
            return handleConstraintViolationException(constraintViolationException);
        } else {
            return new ErrorDto(e.getMessage(), e.getMessage(), e.getClass().getSimpleName());
        }
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleConstraintViolationException(ConstraintViolationException e) {

        final String userMessage = e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(joining("\n"));

        return new ErrorDto(userMessage, e.getMessage(), e.getClass().getSimpleName());
    }

    @ExceptionHandler(EcmApiException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleEcmApiException(EcmApiException e) {

        return new ErrorDto(getEcmErrorMessage(e), e.getMessage(), EcmApiException.class.getSimpleName());
    }

    private String getEcmErrorMessage(EcmApiException ecmApiException) {

        try {
            final Optional<EcmErrorResponse> ecmErrorResponse = getEcmErrorResponse(ecmApiException);
            return ecmErrorResponse
                    .map(EcmErrorResponse::getJustification)
                    .filter(StringUtils::isNotBlank)
                    .orElseGet(() -> getExceptionMessage("ecm.api-exception"));
        } catch (Exception e) {
            LOG.warn("ECM call failed without justification", ecmApiException);
            return getExceptionMessage("ecm.api-exception");
        }
    }

    private Optional<EcmErrorResponse> getEcmErrorResponse(EcmApiException e) throws JsonProcessingException {

        final ApiException apiException = e.getCause();
        if (isNull(apiException)) {
            return Optional.empty();
        }

        final String responseBody = apiException.getResponseBody();
        if (isBlank(responseBody)) {
            return Optional.empty();
        }

        final EcmErrorResponse ecmErrorResponse = objectMapper.readValue(responseBody, EcmErrorResponse.class);
        return Optional.of(ecmErrorResponse);
    }
}
