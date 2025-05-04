package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    private int id;
    private String name;
    private String barcode;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private double price;
    private double costPrice;
    private int quantityInStock;
    private String unit;
    private Boolean status;
}