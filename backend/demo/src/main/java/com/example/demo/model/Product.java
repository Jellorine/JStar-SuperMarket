package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Product {
    @Id
    private int id;
    private String name;
    private String itemcode;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<StockLog> stockLogs;

    private double price;
    private double costPrice;
    private int quantityInStock;
    private String unit;
    private Boolean status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getItemcode() {
		return itemcode;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public List<StockLog> getStockLogs() {
		return stockLogs;
	}
	public void setStockLogs(List<StockLog> stockLogs) {
		this.stockLogs = stockLogs;
	}   
    
}