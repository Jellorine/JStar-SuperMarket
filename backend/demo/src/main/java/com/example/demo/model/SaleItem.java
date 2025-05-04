package com.example.demo.model;

import jakarta.persistence.*;


@Entity
public class SaleItem {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;
    private double price;
    private double total;
}
