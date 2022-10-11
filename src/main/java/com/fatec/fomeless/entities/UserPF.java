package com.fatec.fomeless.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_user_pf")
public class UserPF extends GenericUser implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;
    @Column(name = "cpf")
    private String cpf;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant birthDate;

    public UserPF(Long id, String name, String address, String email, String cpf, Instant birthDate) {
        super(id, name, address, email);
        this.cpf = cpf;
        this.birthDate = birthDate;
    }
}
