package com.fatec.fomeless.dto;

import com.fatec.fomeless.entities.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class EmailDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String emailAddress;

    public EmailDTO(Email email) {
        emailAddress = email.getEmailAddress();
    }
}
