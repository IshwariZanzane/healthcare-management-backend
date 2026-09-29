package com.example.healthcare.repository;

import com.example.healthcare.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> getByDoctor_DoctorId(long doctorId);

    List<Appointment> getByPatient_PatientId(long patientId);

    @Query("SELECT COALESCE(MAX(a.tokenNumber), 0) FROM Appointment a WHERE a.doctor.doctorId = :doctorId")
    int findMaxTokenByDoctorId(@Param("doctorId") long doctorId);

}