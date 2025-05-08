package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.Supplier;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.SupplierRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductByItemCode(String itemCode) {
        return productRepository.findByItemCode(itemCode)
                .orElseThrow(() -> new RuntimeException("Product not found with itemCode: " + itemCode));
    }

    public Product createProduct(Product product) {
    	int categoryId = product.getCategory().getId();
        int supplierId = product.getSupplier().getId();

        Category category = categoryRepository.findById(categoryId)
            .orElseThrow(() -> new RuntimeException("Category not found"));
        Supplier supplier = supplierRepository.findById(supplierId)
            .orElseThrow(() -> new RuntimeException("Supplier not found"));

        product.setCategory(category);
        product.setSupplier(supplier);
        return productRepository.save(product);
    }

    public Product updateProduct(String itemCode, Product product) {
        Product existing = productRepository.findByItemCode(itemCode)
            .orElseThrow(() -> new RuntimeException("Product not found with itemCode: " + itemCode));

        existing.setName(product.getName());
        //existing.setItemcode(product.getItemcode());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setCostPrice(product.getCostPrice());
        existing.setQuantityInStock(product.getQuantityInStock());
        existing.setUnit(product.getUnit());
        existing.setStatus(product.getStatus());

        if (product.getCategory() != null) {
            Category category = categoryRepository.findById(product.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
            existing.setCategory(category);
        }

        if (product.getSupplier() != null) {
            Supplier supplier = supplierRepository.findById(product.getSupplier().getId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
            existing.setSupplier(supplier);
        }

        return productRepository.save(existing);
    }

    public void deleteProduct(String itemCode) {
        Product product = productRepository.findByItemCode(itemCode)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }
}

