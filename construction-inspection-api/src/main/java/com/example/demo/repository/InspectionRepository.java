package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Inspection;

public interface InspectionRepository extends JpaRepository<Inspection, Long> {
}