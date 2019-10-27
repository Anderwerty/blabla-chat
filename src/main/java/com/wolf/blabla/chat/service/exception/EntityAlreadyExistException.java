package com.wolf.blabla.chat.service.exception;

public class EntityAlreadyExistException extends RuntimeException {
    private final int statusCode;

    public EntityAlreadyExistException(int statusCode) {
        this.statusCode = statusCode;
    }

    public EntityAlreadyExistException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
