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
@Table(name = "tb_cnpj")
public class Cnpj implements DocValidation, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserPJ userPJ;

    public Cnpj(String number) {
        validateRegex(number);
        this.number = number;
    }

    @Override
    public void validateRegex(String number) {
        final String regex = "\\d{2}.?\\d{3}.?\\d{3}/?\\d{4}-?\\d{2}";
        if (!number.matches(regex) && !number.isBlank() && !number.isEmpty()) {
            throw new IllegalArgumentException("Invalid number: " + number);
        }
    }
}
