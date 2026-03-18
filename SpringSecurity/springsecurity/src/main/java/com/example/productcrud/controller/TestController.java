package com.example.productcrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/admin/test")
	public String adminTest() {
		return "Admin Dashboard";
	}

	@GetMapping("/user/test")
	public String userTest() {
		return "User Dashboard";
	}
}
