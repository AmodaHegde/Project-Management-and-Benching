package com.webknot.users.controller.errors;

public class InactiveProjectException extends RuntimeException {

    public InactiveProjectException(String message) {
        super(message);
    }
}
