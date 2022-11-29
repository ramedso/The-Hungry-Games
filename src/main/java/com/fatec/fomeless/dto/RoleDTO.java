package com.fatec.fomeless.dto;

import com.fatec.fomeless.entities.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class RoleDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String authority;

    public RoleDTO(Role role) {
        id = role.getId();
        authority = role.getAuthority();
    }
}