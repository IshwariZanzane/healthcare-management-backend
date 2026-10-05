package com.example.healthcare.service;

import com.example.healthcare.dto.VisitRequestDTO;
import com.example.healthcare.dto.VisitResponseDTO;
import com.example.healthcare.entity.Appointment;
import com.example.healthcare.entity.Doctor;
import com.example.healthcare.entity.Patient;
import com.example.healthcare.entity.Visit;
import com.example.healthcare.repository.AppointmentRepository;
import com.example.healthcare.repository.DoctorRepository;
import com.example.healthcare.repository.PatientRepository;
import com.example.healthcare.repository.VisitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitServiceImpl implements VisitService{

    private VisitRepository visitRepository;
    private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;
    private AppointmentRepository appointmentRepository;

    public VisitServiceImpl(VisitRepository visitRepository, PatientRepository patientRepository,DoctorRepository doctorRepository,AppointmentRepository appointmentRepository){
        this.visitRepository=visitRepository;
        this.patientRepository=patientRepository;
        this.doctorRepository=doctorRepository;
        this.appointmentRepository=appointmentRepository;
    }

    @Override
    public List<VisitResponseDTO> getAllVisits(){
        return visitRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public VisitResponseDTO createVisit(VisitRequestDTO request){
        Visit visit = new Visit();
        Patient patient=patientRepository.findById(request.getPatientId())
                .orElseThrow(()->new IllegalArgumentException("Patient doesn't exist."));
        Doctor doctor=doctorRepository.findById(request.getDoctorId())
                .orElseThrow(()->new IllegalArgumentException("Doctor doesn't exist."));
        Appointment appointment=appointmentRepository.findById(request.getAppointmentId())
                .orElseThrow(()->new IllegalArgumentException("Appointment doesn't exist."));
        visit.setPatient(patient);
        visit.setDoctor(doctor);
        visit.setAppointment(appointment);
        visit.setVisitTime(request.getVisitTime());
        visit.setWeight(request.getWeight());
        visit.setHeight(request.getHeight());
        visit.setBloodPressure(request.getBloodPressure());
        visit.setSymptoms(request.getSymptoms());
        visit.setDiagnosis(request.getDiagnosis());
        visit.setPrescription(request.getPrescription());
        visit.setNotes(request.getNotes());

        return toDTO(visitRepository.save(visit));
    }

    @Override
    public VisitResponseDTO updateVisit(long visitId, VisitRequestDTO request){
        Visit existingVisit=visitRepository.findById(visitId)
                .orElseThrow(()->new IllegalArgumentException("Visit Doesn't Exist."));
        Patient patient=patientRepository.findById(request.getPatientId())
                .orElseThrow(()->new IllegalArgumentException("Patient Doesn't Exist."));
        Doctor doctor=doctorRepository.findById(request.getDoctorId())
                .orElseThrow(()->new IllegalArgumentException("Doctor Doesn't Exist."));
        Appointment appointment=appointmentRepository.findById(request.getAppointmentId())
                .orElseThrow(()->new IllegalArgumentException("Appointment Doesn't Exist."));

        existingVisit.setPatient(patient);
        existingVisit.setDoctor(doctor);
        existingVisit.setAppointment(appointment);
        existingVisit.setVisitTime(request.getVisitTime());
        existingVisit.setWeight(request.getWeight());
        existingVisit.setHeight(request.getHeight());
        existingVisit.setBloodPressure(request.getBloodPressure());
        existingVisit.setSymptoms(request.getSymptoms());
        existingVisit.setDiagnosis(request.getDiagnosis());
        existingVisit.setPrescription(request.getPrescription());
        existingVisit.setNotes(request.getNotes());

        return toDTO(visitRepository.save(existingVisit));
    }

    @Override
    public VisitResponseDTO getVisitById(long visitId){
        Visit visit=visitRepository.findById(visitId)
                .orElseThrow(()->new IllegalArgumentException("Visit Doesn't Exist."));
        return toDTO(visit);
    }

    @Override
    public List<VisitResponseDTO> getVisitsByPatient(long patientId){
        return visitRepository.getByPatient_PatientId(patientId).stream().map(this::toDTO).toList();
    }

    @Override
    public List<VisitResponseDTO> getVisitsByDoctor(long doctorId){
        return visitRepository.getByDoctor_DoctorId(doctorId).stream().map(this::toDTO).toList();
    }

    @Override
    public void deleteVisit(long visitId){
        if(!visitRepository.existsById(visitId)){
            throw new IllegalArgumentException("Visit Doesn't Exist.");
        }
        visitRepository.deleteById(visitId);
    }

    private VisitResponseDTO toDTO(Visit visit){
        VisitResponseDTO response=new VisitResponseDTO();
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
    }

}

