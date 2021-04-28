package de.fourtyseveneleven.ones.common.model.dto;

public class ErrorDto {

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
}
