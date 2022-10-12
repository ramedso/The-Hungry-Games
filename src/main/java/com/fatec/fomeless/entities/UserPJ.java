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
@Table(name = "tb_user_pj")
public class UserPJ extends GenericUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant foundationDate;

    @OneToOne(mappedBy = "userPJ", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Cnpj cnpj;

    @OneToOne(mappedBy = "userPJ", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Email email;

    @OneToMany(mappedBy = "userPJPost")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "userPJComment")
    private List<Comment> comments = new ArrayList<>();
}
