package com.example.healthcare.service;

import com.example.healthcare.dto.PatientRequestDTO;
import com.example.healthcare.dto.PatientResponseDTO;
import java.util.List;

public interface PatientService {

    List<PatientResponseDTO> getAllPatients();

    PatientResponseDTO getPatientById(long patientId);

    PatientResponseDTO createPatient(PatientRequestDTO request);

    PatientResponseDTO updatePatient(long patientId, PatientRequestDTO request);

    void deletePatient(long patientId);
}