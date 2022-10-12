package com.fatec.fomeless.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class GenericUser implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    private Long id;
    private String name;
    private String address;

    public GenericUser(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
