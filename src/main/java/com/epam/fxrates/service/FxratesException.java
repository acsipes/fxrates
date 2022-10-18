package com.epam.fxrates.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Andras_Csipes on 4/11/2017.
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class FxratesException extends RuntimeException{

    public FxratesException(String message) {
        super(message);
    }
}
