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
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

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

    @PostMapping
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

        Visit savedVisit=visitRepository.save(visit);

        VisitResponseDTO response = new VisitResponseDTO();
        response.setPatientId(savedVisit.getPatient().getPatientId());
        response.setDoctorId(savedVisit.getDoctor().getDoctorId());
        response.setAppointmentId(savedVisit.getAppointment().getAppmtId());
        response.setVisitTime(savedVisit.getVisitTime());
        response.setWeight(savedVisit.getWeight());
        response.setHeight(savedVisit.getHeight());
        response.setBloodPressure(savedVisit.getBloodPressure());
        response.setSymptoms(savedVisit.getSymptoms());
        response.setDiagnosis(savedVisit.getDiagnosis());
        response.setPrescription(savedVisit.getPrescription());
        response.setNotes(savedVisit.getNotes());
        return response;
    }

    @Override
    public VisitResponseDTO updateVisit(long visitId, VisitRequestDTO request){
        Optional<Visit> visit=visitRepository.findById(visitId);
        if(visit.isPresent()){
            Patient patient=patientRepository.findById(request.getPatientId())
                    .orElseThrow(()->new IllegalArgumentException("Patient Doesn't Exist."));
            Doctor doctor=doctorRepository.findById(request.getDoctorId())
                    .orElseThrow(()->new IllegalArgumentException("Doctor Doesn't Exist."));
            Appointment appointment=appointmentRepository.findById(request.getAppointmentId())
                    .orElseThrow(()->new IllegalArgumentException("Appointment Doesn't Exist."));

            Visit existingVisit=visit.get();
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

            Visit savedVisit=visitRepository.save(existingVisit);

            VisitResponseDTO response=new VisitResponseDTO();
            response.setVisitId(savedVisit.getVisitId());
            response.setPatientId(savedVisit.getPatient().getPatientId());
            response.setDoctorId(savedVisit.getDoctor().getDoctorId());
            response.setAppointmentId(savedVisit.getAppointment().getAppmtId());
            response.setVisitTime(savedVisit.getVisitTime());
            response.setWeight(savedVisit.getWeight());
            response.setHeight(savedVisit.getHeight());
            response.setBloodPressure(savedVisit.getBloodPressure());
            response.setSymptoms(savedVisit.getSymptoms());
            response.setDiagnosis(savedVisit.getDiagnosis());
            response.setPrescription(savedVisit.getPrescription());
            response.setNotes(savedVisit.getNotes());

            return response;
        }
        throw new IllegalArgumentException("Visit Doesn't Exist.");
    }

}

