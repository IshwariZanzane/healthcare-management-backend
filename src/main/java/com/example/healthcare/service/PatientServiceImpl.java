package com.example.healthcare.service;

import com.example.healthcare.dto.PatientRequestDTO;
import com.example.healthcare.dto.PatientResponseDTO;
import com.example.healthcare.entity.Patient;
import com.example.healthcare.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    @Override
    public List<PatientResponseDTO> getAllPatients(){
        List<Patient> patients=patientRepository.findAll();
        return patients.stream()
                .map(patient->{PatientResponseDTO response=new PatientResponseDTO();
                    response.setPatientId(patient.getPatientId());
                    response.setName(patient.getName());
                    response.setEmail(patient.getEmail());
                    response.setMobileNo(patient.getMobileNo());
                    response.setAddress(patient.getAddress());
                    response.setBirthDate(patient.getBirthDate());
                    response.setBloodGroup(patient.getBloodGroup());
                    response.setGender(patient.getGender());
                return response;
                })
                .toList();
    }

    @Override
    public PatientResponseDTO createPatient(PatientRequestDTO request){

        Patient patient=new Patient();
        patient.setName(request.getName());
        patient.setEmail(request.getEmail());
        patient.setMobileNo(request.getMobileNo());
        patient.setAddress(request.getAddress());
        patient.setBloodGroup(request.getBloodGroup());
        patient.setBirthDate(request.getBirthDate());
        patient.setGender(request.getGender());

        Patient savedPatient=patientRepository.save(patient);

        PatientResponseDTO response=new PatientResponseDTO();
        response.setPatientId(savedPatient.getPatientId());
        response.setName(savedPatient.getName());
        response.setEmail(savedPatient.getEmail());
        response.setMobileNo(savedPatient.getMobileNo());
        response.setAddress(savedPatient.getAddress());
        response.setBloodGroup(savedPatient.getBloodGroup());
        response.setBirthDate(savedPatient.getBirthDate());
        response.setGender(savedPatient.getGender());

        return response;
    }

    @Override
    public PatientResponseDTO updatePatient(long patientId, PatientRequestDTO request){
        Optional<Patient> patient=patientRepository.findById(patientId);
        if (patient.isPresent()) {
            Patient existingPatient = patient.get();
            existingPatient.setName(request.getName());
            existingPatient.setEmail(request.getEmail());
            existingPatient.setMobileNo(request.getMobileNo());
            existingPatient.setAddress(request.getAddress());
            existingPatient.setBloodGroup(request.getBloodGroup());
            existingPatient.setBirthDate(request.getBirthDate());
            existingPatient.setGender(request.getGender());

            Patient savedPatient = patientRepository.save(existingPatient);

            PatientResponseDTO response = new PatientResponseDTO();
            response.setPatientId(savedPatient.getPatientId());
            response.setName(savedPatient.getName());
            response.setEmail(savedPatient.getEmail());
            response.setMobileNo(savedPatient.getMobileNo());
            response.setAddress(savedPatient.getAddress());
            response.setBloodGroup(savedPatient.getBloodGroup());
            response.setBirthDate(savedPatient.getBirthDate());
            response.setGender(savedPatient.getGender());

            return response;
        }
        throw new IllegalArgumentException("patient doesn't exist");
    }

    @Override
    public void deletePatient(long patientId){
        Optional<Patient> patient=patientRepository.findById(patientId);
        if(patient.isPresent()){
            Patient existingPatient=patient.get();
            patientRepository.delete(existingPatient);

            return;
        }
        throw new IllegalArgumentException("Patient Doesnt exist");
    }

    @Override
    public PatientResponseDTO getPatientById(long patientId){
        Patient patient=patientRepository.findById(patientId)
                .orElseThrow(()->new IllegalArgumentException("Patient doesn't exist."));

        PatientResponseDTO response=new PatientResponseDTO();
        response.setPatientId(patient.getPatientId());
        response.setName(patient.getName());
        response.setEmail(patient.getEmail());
        response.setMobileNo(patient.getMobileNo());
        response.setAddress(patient.getAddress());
        response.setBirthDate(patient.getBirthDate());
        response.setBloodGroup(patient.getBloodGroup());
        response.setGender(patient.getGender());

        return response;
    }
}