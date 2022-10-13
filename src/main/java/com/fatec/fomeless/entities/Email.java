package com.fatec.fomeless.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_email")
public class Email implements FieldsValidation, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final static String CONST_EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String emailAddress;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    public Email(String emailAddress) {
        emptyOrBlankSpaces(emailAddress);
        regexValidation(emailAddress);
        this.emailAddress = emailAddress.trim();
    }

    @Override
    public void emptyOrBlankSpaces(String docNumber) {
        if (docNumber.isEmpty() || docNumber.isBlank()) {
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


