package com.example.demo.repository;

import com.example.demo.model.StockLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StockLogRepository extends JpaRepository<StockLog, Integer> {
    List<StockLog> findByProductId(int productId);
}
