package com.example.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthcare.entity.Doctor;
import com.example.healthcare.repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    public List<Doctor> getAllDoctors() {
        return repository.findAll();
    }

    public Doctor getDoctor(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Doctor addDoctor(Doctor doctor) {
        return repository.save(doctor);
    }
}
