package com.example.demo.mapper;

import com.example.demo.entity.Inspection;
import com.example.demo.dto.InspectionDTO;

public class InspectionMapper {

    public static InspectionDTO toDTO(Inspection inspection) {
        InspectionDTO dto = new InspectionDTO();
        dto.setId(inspection.getId());
        dto.setSiteName(inspection.getSiteName());
        dto.setInspectorName(inspection.getInspectorName());
        dto.setInspectionDate(inspection.getInspectionDate());
        dto.setRemarks(inspection.getRemarks());
        dto.setPhotoFileName(inspection.getPhotoFileName());
        dto.setReportFileName(inspection.getReportFileName());
        return dto;
    }
}