package com.mudit.shopsphere.repository;

import com.mudit.shopsphere.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}