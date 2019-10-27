package com.wolf.blabla.chat.service.exception;

public class EntityNotFoundException extends RuntimeException {
    private final int statusCode;

    public EntityNotFoundException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public EntityNotFoundException(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
