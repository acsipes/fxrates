package com.epam.fxrates.web.domain;

/**
 * Created by Andras_Csipes on 4/11/2017.
 */
public class ErrorMessage {

    private final String message;

    public ErrorMessage(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
