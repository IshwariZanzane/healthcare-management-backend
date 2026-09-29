package com.example.healthcare.service;

import com.example.healthcare.dto.AppointmentRequestDTO;
import com.example.healthcare.dto.AppointmentResponseDTO;

import java.util.List;

public interface AppointmentService {

    List<AppointmentResponseDTO> getAllAppointments();

    List<AppointmentResponseDTO> getByDoctorId(long doctorId);

    List <AppointmentResponseDTO> getByPatientId(long patientId);

    AppointmentResponseDTO getAppointmentById(long appmt);

    AppointmentResponseDTO createAppointment(AppointmentRequestDTO request);

    AppointmentResponseDTO updateAppointment(long appmtId, AppointmentRequestDTO request);

    void deleteAppointment(long appmtId);
}