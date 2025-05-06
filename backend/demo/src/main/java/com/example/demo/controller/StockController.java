package com.example.demo.controller;

import com.example.demo.model.StockLog;
import com.example.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/add")
    public String addStock(@RequestParam int productId, @RequestParam int quantity, @RequestParam String description) {
        stockService.addStock(productId, quantity, description);
        return "Stock added successfully";
    }

    @PostMapping("/sell")
    public String sellStock(@RequestParam int productId, @RequestParam int quantity, @RequestParam String description) {
        stockService.sellStock(productId, quantity, description);
        return "Stock sold successfully";
    }

    @GetMapping("/logs/{productId}")
    public List<StockLog> getStockLogs(@PathVariable int productId) {
        return stockService.getLogsByProductId(productId);
    }
}
