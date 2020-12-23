package com.sn.lde.ngy.exception;

public class RequiredElementException  extends RuntimeException{

    private String message;
    private String description;

    public RequiredElementException() {
    }

    public RequiredElementException(String message) {
        super(message);
        this.message = message;
    }

    public RequiredElementException(String message, Throwable throwable) {
        super(message, throwable);
        this.message = message;
    }

    public RequiredElementException(String message, String description) {
        super(message);
        this.message = message;
        this.description = description;
    }


    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
