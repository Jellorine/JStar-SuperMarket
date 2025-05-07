package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.Supplier;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.SupplierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SupplierRepository supplierRepository;

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

    @Override
    public Product updateProduct(int id, Product product) {
        Product existing = getProductById(id);
        existing.setName(product.getName());
        existing.setItemcode(product.getItemcode());
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

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}

