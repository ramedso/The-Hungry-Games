package com.fatec.fomeless.dto;

import com.fatec.fomeless.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Mandatory field")
    private String name;

    @NotBlank(message = "Mandatory field")
    private String address;

    @NotBlank(message = "Mandatory field")
    private String phone;

    @PastOrPresent(message = "The date cannot be future ")
    private String signUpDate;

    @javax.validation.constraints.Email(message = "Please entry a valid email")
    private String email;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.address = user.getAddress();
        this.phone = user.getPhone();
        this.signUpDate = user.getSignUpDate();
        this.email = user.getEmail().getEmailAddress();
    }
}
