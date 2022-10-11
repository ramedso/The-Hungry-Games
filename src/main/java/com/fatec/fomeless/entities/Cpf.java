package com.fatec.fomeless.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Cpf {

    private String number;

    public Cpf(String number) {
        if (validateCpf(number)) {
            this.number = number;
        }
    }

    private boolean validateCpf(String number) {
        var regex = "(^(\\d{3}\\.?){3}-?\\d{2}$)";

        if (number.matches(regex)) {
            return true;
        }

        throw new IllegalArgumentException("Invalid number: " + number);
    }
}
