package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Sale;

public interface SalesRepository extends JpaRepository<Sale, Integer> {
    List<Sale> findByInvoiceNumberContaining(String invoiceNumber);
    List<Sale> findByUserId(int userId);
    List<Sale> findByInvoiceNumberContainingAndUserId(String invoiceNumber, int userId);
}

