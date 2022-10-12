package com.fatec.fomeless.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_user_pf")
public class UserPF extends GenericUser implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant birthDate;

    @OneToOne(mappedBy = "userPF", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Email email;

    @OneToOne(mappedBy = "userPF", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Cpf cpf;

    @OneToMany(mappedBy = "userPFPost")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "userPFComment")
    private List<Comment> comments = new ArrayList<>();

    public UserPF(Long id, String name, String address, Cpf cpf, Instant birthDate, Email email) {
        super(id, name, address);
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.email = email;
    }
}
