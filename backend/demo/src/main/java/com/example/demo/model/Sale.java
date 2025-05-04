package com.example.demo.model;

import jakarta.persistence.*;
//import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Sale {
    @Id
    private int id;
    private String invoiceNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private double totalAmount;
    private String paymentMethod;
    private double discount;
    private double netAmount;
    private LocalDateTime saleDate;

    @OneToMany(mappedBy = "sale")
    private List<SaleItem> items;
}
