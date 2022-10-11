package com.fatec.fomeless.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email {
    private final String path;
    public Email(String path) {
        if(!path.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            throw new IllegalArgumentException("Email not valid");
        }
        this.path = path;
    }
}
