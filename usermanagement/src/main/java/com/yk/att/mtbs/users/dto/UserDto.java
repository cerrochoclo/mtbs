package com.yk.att.mtbs.users.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    @NotNull
    private String username;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private RoleDto role;


}
