package com.example.healthcare.service;

import com.example.healthcare.dto.VisitRequestDTO;
import com.example.healthcare.dto.VisitResponseDTO;

import java.util.List;

public interface VisitService{

    List<VisitResponseDTO> getAllVisits();

    VisitResponseDTO getVisitById(long visitId);

    List<VisitResponseDTO> getVisitsByPatient(long patientId);

    List<VisitResponseDTO> getVisitsByDoctor(long doctorId);

    VisitResponseDTO createVisit(VisitRequestDTO request);

    VisitResponseDTO updateVisit(long visitId, VisitRequestDTO request);

    void deleteVisit(long visitId);
}