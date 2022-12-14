package com.fatec.fomeless.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class UserInsertDTO extends UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String password;

    UserInsertDTO(){
        super();
    }
}