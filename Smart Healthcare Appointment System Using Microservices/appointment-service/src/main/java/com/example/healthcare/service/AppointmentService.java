package com.example.healthcare.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthcare.dto.DoctorDTO;
import com.example.healthcare.entity.Appointment;
import com.example.healthcare.event.AppointmentEvent;
import com.example.healthcare.exception.CustomException;
import com.example.healthcare.client.DoctorClient;
import com.example.healthcare.producer.AppointmentProducer;
import com.example.healthcare.repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private DoctorClient doctorClient;

    @Autowired
    private AppointmentProducer producer;

    // ✅ Create Appointment
    public Appointment createAppointment(Appointment appointment) {

        // 🔥 Step 1: Call Doctor Service (Feign)
        DoctorDTO doctor = doctorClient.getDoctor(appointment.getDoctorId());

        // ✅ Step 2: Validate Doctor
        if (doctor == null) {
            throw new CustomException("Doctor not found");
        }

        if (!doctor.isAvailable()) {
            throw new CustomException("Doctor is not available");
        }

        // ✅ Step 3: Save Appointment
        Appointment savedAppointment = repository.save(appointment);

        // 🔥 Step 4: Publish Event to RabbitMQ
        AppointmentEvent event = new AppointmentEvent(
                "Appointment created for patient: " + appointment.getPatientName()
        );

        producer.sendMessage(event);

        return savedAppointment;
    }

    // ✅ Get All Appointments
    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }

    // ✅ Get Appointment by ID
    public Appointment getAppointmentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomException("Appointment not found"));
    }
}