package com.fatec.fomeless.dto;

import com.fatec.fomeless.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Mandatory field")
    private String name;

    @CPF
    @NotBlank(message = "Mandatory field")
    private String cpf;

    @NotBlank(message = "Mandatory field")
    private String address;

    @NotBlank(message = "Mandatory field")
    private String phone;

    @NotBlank(message = "The date cannot be future ")
    private String signUpDate;

    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Please verify your email")
    private String email;

    private Set<RoleDTO> roles = new HashSet<>();

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        cpf = user.getCpf();
        address = user.getAddress();
        phone = user.getPhone();
        signUpDate = user.getSignUpDate();
        email = user.getEmail();
        user.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
    }
}
