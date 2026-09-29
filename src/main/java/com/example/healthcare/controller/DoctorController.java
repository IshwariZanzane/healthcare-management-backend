package com.example.healthcare.controller;

import com.example.healthcare.dto.DoctorRequestDTO;
import com.example.healthcare.dto.DoctorResponseDTO;
import com.example.healthcare.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController{

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService){
        this.doctorService=doctorService;
    }

    @GetMapping("/doctors")
    public List<DoctorResponseDTO> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/doctors/{doctorId}")
    public DoctorResponseDTO getDoctorById(@PathVariable long doctorId){
        return doctorService.getDoctorById(doctorId);
    }

    @PostMapping("/doctors")
    public DoctorResponseDTO createDoctor(@Valid @RequestBody DoctorRequestDTO request){
        return doctorService.createDoctor(request);
    }

    @PutMapping("/doctors/{doctorId}")
    public DoctorResponseDTO updateDoctor(@PathVariable long doctorId, @Valid @RequestBody DoctorRequestDTO request){
        return doctorService.updateDoctor(doctorId,request);
    }

    @DeleteMapping("/doctors/{doctorId}")
    public void deleteDoctor(@PathVariable long doctorId){
        doctorService.deleteDoctor(doctorId);
    }
}