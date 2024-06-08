package com.example.inventorymanagementsystem.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    long countByQty(int qty);
    long countByQtyLessThanAndQtyGreaterThan(int threshold, int minQty);
}
