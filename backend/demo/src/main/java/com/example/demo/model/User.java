package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String name;
    private String role;
    private Boolean status;
}
