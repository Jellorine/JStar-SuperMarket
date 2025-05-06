package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Sale;
import com.example.demo.model.SaleItem;
import com.example.demo.repository.SaleItemRepository;
import com.example.demo.repository.SalesRepository;

@Service
public class SaleService {
    @Autowired
    private SalesRepository saleRepository;
    
    @Autowired
    private SaleItemRepository saleItemRepository;

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public List<Sale> getSalesByInvoiceNumber(String invoiceNumber) {
        return saleRepository.findByInvoiceNumberContaining(invoiceNumber);
    }

    public List<Sale> getSalesByUserId(int userId) {
        return saleRepository.findByUserId(userId);
    }

    public List<Sale> getSalesByInvoiceAndUser(String invoiceNumber, int userId) {
        return saleRepository.findByInvoiceNumberContainingAndUserId(invoiceNumber, userId);
    }

    public Sale getSaleById(int id) {
        return saleRepository.findById(id).orElse(null);
    }

    public Sale createSale(Sale sale) {
        Sale savedSale = saleRepository.save(sale);
        for (SaleItem item : sale.getItems()) {
            item.setSale(savedSale);
            saleItemRepository.save(item);
        }
        return savedSale;
    }

    public void deleteSale(int id) {
        saleRepository.deleteById(id);
    }
}

