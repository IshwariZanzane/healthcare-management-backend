package com.example.healthcare.controller;

import com.example.healthcare.dto.VisitRequestDTO;
import com.example.healthcare.dto.VisitResponseDTO;
import com.example.healthcare.service.VisitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visits")
public class VisitController{
    private VisitService visitService;

    public VisitController(VisitService visitService){
        this.visitService=visitService;
    }

    @GetMapping("")
    public List<VisitResponseDTO> getAllVisit(){
        return visitService.getAllVisits();
    }

    @GetMapping("/{visitId}")
    public VisitResponseDTO getVisitById(@PathVariable long visitId){
        return visitService.getVisitById(visitId);
    }

    @GetMapping("/patient/{patientId}")
    public List<VisitResponseDTO> getVisitsByPatient(@PathVariable long patientId){
        return visitService.getVisitsByPatient(patientId);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<VisitResponseDTO> getVisitsByDoctor(@PathVariable long doctorId){
        return visitService.getVisitsByDoctor(doctorId);
    }

    @PostMapping("")
    public VisitResponseDTO createVisit(@RequestBody VisitRequestDTO request){
        return visitService.createVisit(request);
    }

    @PutMapping("/{visitId}")
    public VisitResponseDTO updateVisit(@PathVariable long visitId, @RequestBody VisitRequestDTO request){
        return visitService.updateVisit(visitId,request);
    }

    @DeleteMapping("/{visitId}")
    public void deleteVisit(@PathVariable long visitId){
        visitService.deleteVisit(visitId);
    }
}