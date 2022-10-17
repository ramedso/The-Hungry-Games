package com.fatec.fomeless.services.exceptions;

import java.io.Serial;

public class InvalidEmailException extends Exception{

    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidEmailException(String msg) {
        super(msg);
    }
}
