package com.example.productcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productcrud.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
