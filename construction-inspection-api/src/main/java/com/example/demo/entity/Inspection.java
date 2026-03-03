package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String siteName;
    private String inspectorName;
    private LocalDate inspectionDate;
    private String remarks;

    private String photoFileName;
    private String reportFileName;

    public Inspection() {}

    public Inspection(String siteName, String inspectorName, LocalDate inspectionDate,
                      String remarks, String photoFileName, String reportFileName) {
        this.siteName = siteName;
        this.inspectorName = inspectorName;
        this.inspectionDate = inspectionDate;
        this.remarks = remarks;
        this.photoFileName = photoFileName;
        this.reportFileName = reportFileName;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getInspectorName() {
		return inspectorName;
	}

	public void setInspectorName(String inspectorName) {
		this.inspectorName = inspectorName;
	}

	public LocalDate getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(LocalDate inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getReportFileName() {
		return reportFileName;
	}

	public void setReportFileName(String reportFileName) {
		this.reportFileName = reportFileName;
	}

    	
}