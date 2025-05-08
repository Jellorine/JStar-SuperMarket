package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{itemCode}")
    public Product getProductByItemCode(@PathVariable String itemCode) {
        return productService.getProductByItemCode(itemCode);
    }

    @PostMapping("/add")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{itemCode}")
    public Product updateProduct(@PathVariable String itemCode, @RequestBody Product product) {
        return productService.updateProduct(itemCode, product);
    }

    @DeleteMapping("/{itemCode}")
    public void deleteProduct(@PathVariable String itemCode) {
        productService.deleteProduct(itemCode);
    }
}

