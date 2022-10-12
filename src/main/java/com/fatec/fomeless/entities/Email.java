package com.fatec.fomeless.entities;

import com.fatec.fomeless.entities.Validations.DocValidation;
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
public class Email implements DocValidation, Serializable {

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
    private UserPF userPF;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserPJ userPJ;

    public Email(String emailAddress) {
        validateRegex(emailAddress);
        this.emailAddress = emailAddress;
    }

    @Override
    public void validateRegex(String doc) {
        if (!doc.matches(CONST_EMAIL_REGEX) && !doc.isBlank() && !doc.isEmpty()) {
            throw new IllegalArgumentException("Invalid email: " + doc);
        }
    }
}
