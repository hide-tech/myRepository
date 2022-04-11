package com.yazykov.projectf.models.security;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Data
@Table(name = "users")
@Validated
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "username should be not empty")
    @Size(min=2, max=50, message = "username should be between 2 and 50 chars")
    @Column(name = "username")
    private String username;

    @NotEmpty(message = "email should not be empty")
    @Email
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "first name should not be empty")
    @Size(min=2, max = 30, message = "first name should be between 2 and 30 chars")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "last name should not be empty")
    @Size(min=2, max = 30, message = "last name should be between 2 and 30 chars")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "created")
    private LocalDateTime created;
    @Column(name = "updated")

    private LocalDateTime updated;
    @Column(name = "status")

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

}
