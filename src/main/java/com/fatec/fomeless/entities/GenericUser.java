package com.fatec.fomeless.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name = "tb_user")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class GenericUser implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String email;

    @OneToMany(mappedBy = "userPost")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "userComment")
    private List<Comment> comments = new ArrayList<>();

    public GenericUser(Long id, String name, String address, String email) {
        emailValidator(email);
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public void emailValidator(String email){
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Invalid email: " + email);
        }
    }
}
