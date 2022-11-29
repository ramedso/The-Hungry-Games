package com.fatec.fomeless.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
public class UserUpdateDTO extends UserInsertDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    UserUpdateDTO() {
        super();
    }
}
