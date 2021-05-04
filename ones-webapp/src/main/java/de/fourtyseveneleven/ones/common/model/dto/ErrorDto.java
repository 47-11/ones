package de.fourtyseveneleven.ones.common.model.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class ErrorDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -6627895306441980241L;

    private String userMessage;
    private String exceptionMessage;
    private String exceptionType;

    public ErrorDto(String userMessage, String exceptionMessage, String exceptionType) {
        this.userMessage = userMessage;
        this.exceptionMessage = exceptionMessage;
        this.exceptionType = exceptionType;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ErrorDto errorDto = (ErrorDto) o;
        return Objects.equals(userMessage, errorDto.userMessage)
                && Objects.equals(exceptionMessage, errorDto.exceptionMessage)
                && exceptionType.equals(errorDto.exceptionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userMessage, exceptionMessage, exceptionType);
    }
}
