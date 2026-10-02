package com.example.healthcare.service;

import com.example.healthcare.dto.VisitResponseDTO;
import com.example.healthcare.entity.Visit;
import com.example.healthcare.repository.VisitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitServiceImpl implements VisitService{

    private VisitRepository visitRepository;

    public VisitServiceImpl(VisitRepository visitRepository){
        this.visitRepository=visitRepository;
    }

    @Override
    public List<VisitResponseDTO> getAllVisits(){
        List<Visit> visits=visitRepository.findAll();
        return visits.stream()
                .map(visit ->{VisitResponseDTO response = new VisitResponseDTO();
            response.setVisitId(visit.getVisitId());
            response.setPatientId(visit.getPatient().getPatientId());
            response.setDoctorId(visit.getDoctor().getDoctorId());
            response.setAppointmentId(visit.getAppointment().getAppmtId());
            response.setVisitTime(visit.getVisitTime());
            response.setWeight(visit.getWeight());
            response.setHeight(visit.getHeight());
            response.setBloodPressure(visit.getBloodPressure());
            response.setSymptoms(visit.getSymptoms());
            response.setDiagnosis(visit.getDiagnosis());
            response.setPrescription(visit.getPrescription());
            response.setNotes(visit.getNotes());
            return response;
            }).toList();
    }

}