package com.example.healthcare.service;

import com.example.healthcare.dto.VisitRequestDTO;
import com.example.healthcare.dto.VisitResponseDTO;

import java.util.List;

public interface VisitService{

    List<VisitResponseDTO> getAllVisits();

    VisitResponseDTO createVisit(VisitRequestDTO request);
}