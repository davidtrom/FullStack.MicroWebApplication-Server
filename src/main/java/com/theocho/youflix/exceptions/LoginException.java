package com.theocho.youflix.exceptions;

import java.sql.SQLException;

public class LoginException extends SQLException {
    public LoginException(String message) {
        super(message);
    }
}
