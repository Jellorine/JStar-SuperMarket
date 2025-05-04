package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    private int id;

    private String username;
    private String password;
    private String name;
    private String role;
    private Boolean status;

    @OneToMany(mappedBy = "user")
    private List<Sale> sales;
}
