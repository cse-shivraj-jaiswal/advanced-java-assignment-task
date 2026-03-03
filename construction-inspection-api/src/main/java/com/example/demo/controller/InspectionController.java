package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.*;
import com.example.demo.dto.*;

@RestController
@RequestMapping("/api/inspections")
public class InspectionController {

    private final InspectionService service;

    public InspectionController(InspectionService service) {
        this.service = service;
    }

    // 🔹 ADD THIS METHOD
    @GetMapping
    public String testApi() {
        return "Inspection API is running successfully!";
    }

    @PostMapping
    public ResponseEntity<InspectionDTO> createInspection(
            @RequestParam String siteName,
            @RequestParam String inspectorName,
            @RequestParam String inspectionDate,
            @RequestParam(required = false) String remarks,
            @RequestParam MultipartFile sitePhoto,
            @RequestParam MultipartFile safetyReport) {

        InspectionDTO dto = service.createInspection(
                siteName, inspectorName, inspectionDate,
                remarks, sitePhoto, safetyReport);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InspectionDTO> getInspection(@PathVariable Long id) {
        return ResponseEntity.ok(service.getInspection(id));
    }
}