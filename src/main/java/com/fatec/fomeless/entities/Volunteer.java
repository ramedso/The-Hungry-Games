package com.fatec.fomeless.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_volunteer")
public class Volunteer extends User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Column(name = "cpf")
    private Cpf cpf;
    @Column(name = "birthDate")
    private Instant birthDate;

    public Volunteer(Long id, String name, String address, String email, Cpf cpf, Instant birthDate) {
        super(id, name, address, email);
        this.cpf = cpf;
        this.birthDate = birthDate;
    }
}
