package com.example.healthcare.repository;

import com.example.healthcare.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    List<Visit> getByPatient_PatientId(long patientId);

    List<Visit> getByDoctor_DoctorId(long doctorId);

    List<Visit> getByAppointment_AppmtId(long appmtId);
}