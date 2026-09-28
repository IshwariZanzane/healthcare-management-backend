package com.example.healthcare.service;

import com.example.healthcare.dto.DoctorRequestDTO;
import com.example.healthcare.dto.DoctorResponseDTO;

import java.util.List;

public interface DoctorService{

    List<DoctorResponseDTO> getAllDoctors();

    DoctorResponseDTO getDoctorById(long doctorId);

    DoctorResponseDTO createDoctor(DoctorRequestDTO request);

    DoctorResponseDTO updateDoctor(long doctorId, DoctorRequestDTO request);

    void deleteDoctor(long doctorId);
}