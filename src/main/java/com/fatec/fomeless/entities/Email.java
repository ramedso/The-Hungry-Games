package com.fatec.fomeless.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Email implements FieldsValidation, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final static String CONST_EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private Long id;
    private String emailAddress;

    @JsonIgnore
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    public Email(Long id, String emailAddress) {
        emptyOrBlankSpaces(emailAddress);
        regexValidation(emailAddress);
        this.id = id;
        this.emailAddress = emailAddress.trim();
    }

    @Override
    public void emptyOrBlankSpaces(String emailAddress) {
        if (emailAddress.isEmpty() || emailAddress.isBlank()) {
            throw new IllegalArgumentException("There are blank spaces");
        }
    }

    @Override
    public void regexValidation(String obj) {
        if (!obj.matches(CONST_EMAIL_REGEX)) {
            throw new IllegalArgumentException("Invalid email: " + obj);
        }
    }
}


