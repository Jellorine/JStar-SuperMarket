package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.StockLog;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StockLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockLogRepository stockLogRepository;

    public void addStock(int productId, int quantity, String description) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setQuantityInStock(product.getQuantityInStock() + quantity);
        productRepository.save(product);

        StockLog log = new StockLog();
        log.setProduct(product);
        log.setChangeType("ADD");
        log.setQuantity(quantity);
        log.setDescription(description);
        log.setTimestamp(LocalDateTime.now());

        stockLogRepository.save(log);
    }

    public void sellStock(int productId, int quantity, String description) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getQuantityInStock() < quantity) {
            throw new IllegalArgumentException("Not enough stock");
        }

        product.setQuantityInStock(product.getQuantityInStock() - quantity);
        productRepository.save(product);

        StockLog log = new StockLog();
        log.setProduct(product);
        log.setChangeType("SALE");
        log.setQuantity(quantity);
        log.setDescription(description);
        log.setTimestamp(LocalDateTime.now());

        stockLogRepository.save(log);
    }

    public List<StockLog> getLogsByProductId(int productId) {
        return stockLogRepository.findByProductId(productId);
    }
}
