package com.example.healthcare.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.example.healthcare.dto.DoctorDTO;

@FeignClient(name = "doctor-service")
public interface DoctorClient {

    @GetMapping("/doctors/{id}")
    DoctorDTO getDoctor(@PathVariable Long id);
}
