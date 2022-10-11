package com.fatec.fomeless.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_user_pj")
public class UserPJ extends GenericUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant foundationDate;
}
