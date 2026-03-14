package com.example.productcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import com.example.productcrud.model.Product;
import com.example.productcrud.repository.ProductRepository;

@RestController
@RequestMapping("/products")
@EnableMethodSecurity
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
	@GetMapping
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
}
