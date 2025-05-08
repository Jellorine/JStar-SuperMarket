package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByItemCode(String itemCode);
    void deleteByItemCode(String itemCode);
}

