package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import com.example.demo.repository.InspectionRepository;
import com.example.demo.entity.Inspection;
import com.example.demo.dto.InspectionDTO;
import com.example.demo.mapper.InspectionMapper;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class InspectionServiceImpl implements InspectionService {

    private final InspectionRepository repository;

    public InspectionServiceImpl(InspectionRepository repository) {
        this.repository = repository;
    }

    @Override
    public InspectionDTO createInspection(String siteName,
                                          String inspectorName,
                                          String inspectionDate,
                                          String remarks,
                                          MultipartFile sitePhoto,
                                          MultipartFile safetyReport) {

        // Validate files
        if (sitePhoto == null || sitePhoto.isEmpty()) {
            throw new RuntimeException("Site photo is required");
        }

        if (safetyReport == null || safetyReport.isEmpty()) {
            throw new RuntimeException("Safety report is required");
        }

        String photoType = sitePhoto.getContentType();
        String reportType = safetyReport.getContentType();

        if (photoType == null || !photoType.startsWith("image/")) {
            throw new RuntimeException("Invalid photo type. Only JPG or PNG allowed.");
        }

        if (reportType == null || !reportType.equals("application/pdf")) {
            throw new RuntimeException("Invalid report type. Only PDF allowed.");
        }

        // Create entity
        Inspection inspection = new Inspection(
                siteName,
                inspectorName,
                LocalDate.parse(inspectionDate),
                remarks,
                sitePhoto.getOriginalFilename(),
                safetyReport.getOriginalFilename()
        );

        // Save to database
        Inspection saved = repository.save(inspection);

        // File upload
        try {
            String baseDir = System.getProperty("user.dir");

            String folderPath = baseDir
                    + File.separator + "uploads"
                    + File.separator + "inspections"
                    + File.separator + saved.getId();

            Path uploadPath = Paths.get(folderPath);
            Files.createDirectories(uploadPath);

            File photoFile = new File(folderPath, sitePhoto.getOriginalFilename());
            File reportFile = new File(folderPath, safetyReport.getOriginalFilename());

            sitePhoto.transferTo(photoFile);
            safetyReport.transferTo(reportFile);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("File upload failed: " + e.getMessage());
        }

        return InspectionMapper.toDTO(saved);
    }

    @Override
    public InspectionDTO getInspection(Long id) {
        Inspection inspection = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inspection not found"));

        return InspectionMapper.toDTO(inspection);
    }
}