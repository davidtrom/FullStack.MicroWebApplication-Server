package com.theocho.youflix.exceptions;

public class NewUserException extends IllegalArgumentException {

    public NewUserException(String message) {
        super(message);
    }
}
