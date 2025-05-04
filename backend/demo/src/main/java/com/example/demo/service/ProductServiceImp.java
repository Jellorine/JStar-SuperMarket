package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product existing = getProductById(id);
        existing.setName(product.getName());
        existing.setBarcode(product.getBarcode());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setCostPrice(product.getCostPrice());
        existing.setQuantityInStock(product.getQuantityInStock());
        existing.setUnit(product.getUnit());
        existing.setStatus(product.getStatus());
        existing.setCategory(product.getCategory());
        return productRepository.save(existing);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}

