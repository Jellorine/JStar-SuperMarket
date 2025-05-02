package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Integer loyaltyPoints;
}
