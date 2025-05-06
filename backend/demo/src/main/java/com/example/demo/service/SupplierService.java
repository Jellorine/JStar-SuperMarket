package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Supplier;
import com.example.demo.repository.SupplierRepository;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(int id) {
        return supplierRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Supplier not found with ID: " + id));
    }

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(int id, Supplier updatedSupplier) {
        Supplier existing = getSupplierById(id);
        existing.setName(updatedSupplier.getName());
        existing.setContactPerson(updatedSupplier.getContactPerson());
        existing.setPhone(updatedSupplier.getPhone());
        existing.setEmail(updatedSupplier.getEmail());
        existing.setAddress(updatedSupplier.getAddress());
        return supplierRepository.save(existing);
    }

    public void deleteSupplier(int id) {
        Supplier existing = getSupplierById(id);
        supplierRepository.delete(existing);
    }
}
