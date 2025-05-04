package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class StockLog {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String changeType;
    private Integer quantity;
    private String description;
    private LocalDateTime timestamp;
}

