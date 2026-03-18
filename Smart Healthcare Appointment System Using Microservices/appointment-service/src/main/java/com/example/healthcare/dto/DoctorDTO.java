package com.example.healthcare.dto;

import lombok.Data;

@Data
public class DoctorDTO {

    private Long id;
    private String name;
    private String specialization;
    private String hospital;
    private boolean available;
	public DoctorDTO(Long id, String name, String specialization, String hospital, boolean available) {
		super();
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.hospital = hospital;
		this.available = available;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
    
}
