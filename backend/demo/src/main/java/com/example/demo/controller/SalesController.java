package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Sale;
import com.example.demo.service.SaleService;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {
    @Autowired
    private SaleService saleService;
    
    @PostMapping("/add")
    public Sale addSale(@RequestBody Sale sale) {
        return saleService.createSale(sale);
    }

    @GetMapping("/{id}")
    public Sale getSale(@PathVariable int id) {
        return saleService.getSaleById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSale(@PathVariable int id) {
        saleService.deleteSale(id);
    }

    @GetMapping
    public List<Sale> getSales(
        @RequestParam(required = false) String invoiceNumber,
        @RequestParam(required = false) Integer userId
    ) {
        if (invoiceNumber != null && userId != null) {
            return saleService.getSalesByInvoiceAndUser(invoiceNumber, userId);
        } else if (invoiceNumber != null) {
            return saleService.getSalesByInvoiceNumber(invoiceNumber);
        } else if (userId != null) {
            return saleService.getSalesByUserId(userId);
        } else {
            return saleService.getAllSales();
        }
    }

    
}

