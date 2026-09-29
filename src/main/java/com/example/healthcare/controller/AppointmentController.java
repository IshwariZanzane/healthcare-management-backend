package com.example.healthcare.controller;

import com.example.healthcare.dto.AppointmentRequestDTO;
import com.example.healthcare.dto.AppointmentResponseDTO;
import com.example.healthcare.service.AppointmentService;
import com.example.healthcare.service.AppointmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController{

    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService=appointmentService;
    }

    @GetMapping("")
    public List<AppointmentResponseDTO> getAllAppointment(){
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{appmtId}")
    public AppointmentResponseDTO getAppointmentById(@PathVariable long appmtId){
        return appointmentService.getAppointmentById(appmtId);
    }
    @GetMapping("/doctor/{doctorId}")
    public List<AppointmentResponseDTO> getByDoctorId(@PathVariable long doctorId){
        return appointmentService.getByDoctorId(doctorId);
    }
    @GetMapping("/patient/{patientId}")
    public List<AppointmentResponseDTO> getByPatientId(@PathVariable long patientId){
        return appointmentService.getByPatientId(patientId);
    }
    @PostMapping("")
    public AppointmentResponseDTO createAppointment(@Valid @RequestBody AppointmentRequestDTO request){
        return appointmentService.createAppointment(request);
    }
    @PutMapping("/{appmtId}")
    public AppointmentResponseDTO updateAppointment(@PathVariable long appmtId,@Valid @RequestBody AppointmentRequestDTO request){
        return appointmentService.updateAppointment(appmtId, request);
    }
    @DeleteMapping("/{appmtId}")
    public void deleteAppointment(@PathVariable long appmtId){
        appointmentService.deleteAppointment(appmtId);
    }

}