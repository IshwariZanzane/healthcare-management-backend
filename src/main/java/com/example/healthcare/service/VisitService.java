package com.example.healthcare.service;

import com.example.healthcare.dto.VisitResponseDTO;

import java.util.List;

public interface VisitService{

    List<VisitResponseDTO> getAllVisits();
}