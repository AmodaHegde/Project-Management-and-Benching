package com.springboot.users.controller.errors;

public class InactiveProjectException extends RuntimeException {

    public InactiveProjectException(String message) {
        super(message);
    }
}
