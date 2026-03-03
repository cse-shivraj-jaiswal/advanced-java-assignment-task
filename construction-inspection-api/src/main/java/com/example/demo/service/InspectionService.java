package com.example.demo.service;

import com.example.demo.dto.InspectionDTO;
import org.springframework.web.multipart.MultipartFile;

public interface InspectionService {
    InspectionDTO createInspection(String siteName,
                                   String inspectorName,
                                   String inspectionDate,
                                   String remarks,
                                   MultipartFile sitePhoto,
                                   MultipartFile safetyReport);

    InspectionDTO getInspection(Long id);
}
