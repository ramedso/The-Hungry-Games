package com.fatec.fomeless.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_user")
public class User implements Serializable, UserDetails {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String password;
    private String address;
    private String phone;
    private String signUpDate;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    @Setter(AccessLevel.NONE)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public String dateFormat(){
        LocalDate obj = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return obj.format(dateTimeFormatter);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
