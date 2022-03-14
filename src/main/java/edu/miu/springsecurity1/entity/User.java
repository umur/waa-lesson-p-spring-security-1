package edu.miu.springsecurity1.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @OneToOne(mappedBy = "user")
    private Product product;

    @ManyToMany
    @JoinTable
    private List<Role> roles;
}
