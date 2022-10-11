package com.fatec.fomeless.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_users")
public abstract class User implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name;
    protected String address;
    protected String email;

    public User(Long id, String name, String address, String email) {
        emailValidator(email);
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public void emailValidator(String email){
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Invalid email");
        }
    }
}
