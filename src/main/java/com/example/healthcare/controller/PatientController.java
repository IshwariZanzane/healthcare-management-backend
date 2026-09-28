package com.example.healthcare.controller;

import com.example.healthcare.dto.PatientRequestDTO;
import com.example.healthcare.dto.PatientResponseDTO;
import com.example.healthcare.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController{

    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }

    @GetMapping("/patients")
    public List<PatientResponseDTO> getEmployeeById(){
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{patientId}")
    public PatientResponseDTO getPatientById(@PathVariable long patientId){
        return patientService.getPatientById(patientId);
    }

    @PostMapping("/patients")
    public PatientResponseDTO createPatient(@Valid @RequestBody PatientRequestDTO request){
        return patientService.createPatient(request);
    }

    @PutMapping("/patients/{patientId}")
    public PatientResponseDTO updatePatient(@PathVariable long patientId, @Valid @RequestBody PatientRequestDTO request){
        return patientService.updatePatient(patientId,request);
    }

    @DeleteMapping("patients/{patientId}")
    public void deletePatient(@PathVariable long patientId){
        patientService.deletePatient(patientId);
    }
}