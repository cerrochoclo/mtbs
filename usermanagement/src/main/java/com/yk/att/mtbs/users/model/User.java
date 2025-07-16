package com.yk.att.mtbs.users.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "mtbsuser")
public class User{

    @Id
    @Column(name="username")
    private String username;

    private String name;

    private String email;

    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Override
    public String toString() {
        return String.format("username: %s, name: %s, email: %s, password: %s, role: %s", username,name,email,password, role);
    }
}
