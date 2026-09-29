package com.example.healthcare.service;

import com.example.healthcare.dto.AppointmentRequestDTO;
import com.example.healthcare.dto.AppointmentResponseDTO;
import com.example.healthcare.entity.Appointment;
import com.example.healthcare.entity.Doctor;
import com.example.healthcare.entity.Patient;
import com.example.healthcare.repository.AppointmentRepository;
import com.example.healthcare.repository.DoctorRepository;
import com.example.healthcare.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    private AppointmentRepository appointmentRepository;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository,DoctorRepository doctorRepository, PatientRepository patientRepository){
        this.appointmentRepository=appointmentRepository;
        this.doctorRepository=doctorRepository;
        this.patientRepository=patientRepository;
    }

    @Override
    public List<AppointmentResponseDTO> getAllAppointments(){
        List<Appointment> appointments=appointmentRepository.findAll();

        return appointments.stream()
                .map(appointment -> {AppointmentResponseDTO response=new AppointmentResponseDTO();
                response.setAppmtId(appointment.getAppmtId());
                response.setDoctorId(appointment.getDoctor().getDoctorId());
                response.setDoctorName(appointment.getDoctor().getName());
                response.setPatientId(appointment.getPatient().getPatientId());
                response.setPatientName(appointment.getPatient().getName());
                response.setStartTime(appointment.getStartTime());
                response.setEndTime(appointment.getEndTime());
                response.setReason(appointment.getReason());
                response.setStatus(appointment.getStatus());
                response.setTokenNumber(appointment.getTokenNumber());
                    return response;
                }).toList();
    }

    @Override
    public AppointmentResponseDTO getAppointmentById(long appmtId){
        Appointment appointment=appointmentRepository.findById(appmtId)
                .orElseThrow(()->new IllegalArgumentException("Appointment Doesn't Exist."));
        AppointmentResponseDTO response=new AppointmentResponseDTO();
        response.setAppmtId(appointment.getAppmtId());
        response.setDoctorId(appointment.getDoctor().getDoctorId());
        response.setDoctorName(appointment.getDoctor().getName());
        response.setPatientId(appointment.getPatient().getPatientId());
        response.setPatientName(appointment.getPatient().getName());
        response.setStartTime(appointment.getStartTime());
        response.setEndTime(appointment.getEndTime());
        response.setTokenNumber(appointment.getTokenNumber());
        response.setReason(appointment.getReason());
        response.setStatus(appointment.getStatus());

        return response;
    }

    @Override
    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO request){
        Appointment appointment=new Appointment();
        Doctor doctor=doctorRepository.findById(request.getDoctorId())
                .orElseThrow(()->new IllegalArgumentException("Doctor Doesn't Exist."));
        Patient patient=patientRepository.findById(request.getPatientId())
                        .orElseThrow(()-> new IllegalArgumentException("Patient Doesn't Exist"));
        int token = appointmentRepository.findMaxTokenByDoctorId(request.getDoctorId()) + 1;

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setStartTime(request.getStartTime());
        appointment.setEndTime(request.getEndTime());
        appointment.setTokenNumber(token);
        appointment.setReason(request.getReason());
        appointment.setStatus(request.getStatus().name());

        Appointment savedAppointment=appointmentRepository.save(appointment);

        AppointmentResponseDTO response =new AppointmentResponseDTO();
        response.setAppmtId(savedAppointment.getAppmtId());
        response.setDoctorId(savedAppointment.getDoctor().getDoctorId());
        response.setDoctorName(savedAppointment.getDoctor().getName());
        response.setPatientId(savedAppointment.getPatient().getPatientId());
        response.setPatientName(savedAppointment.getPatient().getName());
        response.setStartTime(savedAppointment.getStartTime());
        response.setEndTime(savedAppointment.getEndTime());
        response.setTokenNumber(savedAppointment.getTokenNumber());
        response.setReason(savedAppointment.getReason());
        response.setStatus(savedAppointment.getStatus());

        return response;
    }

    @Override
    public AppointmentResponseDTO updateAppointment(long appmtId, AppointmentRequestDTO request){
        Optional<Appointment> appointment=appointmentRepository.findById(appmtId);
        if(appointment.isPresent()){
            Doctor doctor=doctorRepository.findById(request.getDoctorId())
                    .orElseThrow(()->new IllegalArgumentException("Doctor Doesn't Exist."));
            Patient patient=patientRepository.findById(request.getPatientId())
                    .orElseThrow(()->new IllegalArgumentException("Patient Doesn't Exist"));

            Appointment existingAppointment=appointment.get();
            existingAppointment.setDoctor(doctor);
            existingAppointment.setPatient(patient);
            existingAppointment.setStartTime(request.getStartTime());
            existingAppointment.setEndTime(request.getEndTime());
            existingAppointment.setReason(request.getReason());
            existingAppointment.setStatus(request.getStatus().name());

            Appointment savedAppointment=appointmentRepository.save(existingAppointment);

            AppointmentResponseDTO response=new AppointmentResponseDTO();
            response.setAppmtId(savedAppointment.getAppmtId());
            response.setDoctorId(savedAppointment.getDoctor().getDoctorId());
            response.setDoctorName((savedAppointment.getDoctor().getName()));
            response.setPatientId(savedAppointment.getPatient().getPatientId());
            response.setPatientName(savedAppointment.getPatient().getName());
            response.setStartTime(savedAppointment.getStartTime());
            response.setEndTime(savedAppointment.getEndTime());
            response.setTokenNumber(savedAppointment.getTokenNumber());
            response.setReason(savedAppointment.getReason());
            response.setStatus(savedAppointment.getStatus());

            return response;
        }
        throw new IllegalArgumentException("Appointment Doesn't Exist");
    }

    @Override
    public List<AppointmentResponseDTO> getByDoctorId(long doctorId){
        List<Appointment> appointments = appointmentRepository.getByDoctor_DoctorId(doctorId);
        return appointments.stream().map(appointment -> {
            AppointmentResponseDTO response = new AppointmentResponseDTO();
            response.setAppmtId(appointment.getAppmtId());
            response.setDoctorId(appointment.getDoctor().getDoctorId());
            response.setDoctorName(appointment.getDoctor().getName());
            response.setPatientId(appointment.getPatient().getPatientId());
            response.setPatientName(appointment.getPatient().getName());
            response.setStartTime(appointment.getStartTime());
            response.setEndTime(appointment.getEndTime());
            response.setTokenNumber(appointment.getTokenNumber());
            response.setReason(appointment.getReason());
            response.setStatus(appointment.getStatus());
            return response;
        }).toList();
    }

    @Override
    public List<AppointmentResponseDTO> getByPatientId(long patientId){
        List<Appointment> appointments = appointmentRepository.getByPatient_PatientId(patientId);
        return appointments.stream().map(appointment -> {
            AppointmentResponseDTO response = new AppointmentResponseDTO();
            response.setAppmtId(appointment.getAppmtId());
            response.setDoctorId(appointment.getDoctor().getDoctorId());
            response.setDoctorName(appointment.getDoctor().getName());
            response.setPatientId(appointment.getPatient().getPatientId());
            response.setPatientName(appointment.getPatient().getName());
            response.setStartTime(appointment.getStartTime());
            response.setEndTime(appointment.getEndTime());
            response.setTokenNumber(appointment.getTokenNumber());
            response.setReason(appointment.getReason());
            response.setStatus(appointment.getStatus());
            return response;
        }).toList();
    }

    @Override
    public void deleteAppointment(long appmtId){
        if(!appointmentRepository.existsById(appmtId)){
            throw new IllegalArgumentException("Appointment Doesn't Exist");
        }
        appointmentRepository.deleteById(appmtId);
    }
}