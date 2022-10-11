package com.fatec.fomeless.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;
import java.text.SimpleDateFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_volunteer")
public class Volunteer extends User{

    @Column(name = "cpf")
    private Document cpf;

    @Column(name = "birthDate")
    private SimpleDateFormat birthDate;

    public Volunteer(Long id, String name, Address address, Email email, Document cpf, SimpleDateFormat birthDate) {
        super(id, name, address, email);
        this.cpf = cpf;
        this.birthDate = birthDate;
    }
}
