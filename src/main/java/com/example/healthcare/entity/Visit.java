package com.example.healthcare.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="visits")
public class Visit{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="visit_id")
    private long visitId;

    @ManyToOne
    @JoinColumn(name="patient_id",nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="doctor_id",nullable = false)
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name="appmt_id",nullable = false, unique = true)
    private Appointment appointment;

    @Column(name="visit_time")
    private LocalDateTime visitTime;

    @Column(name="weight")
    private double weight;

    @Column(name="height")
    private double height;

    @Column(name="bp")
    private String bloodPressure;

    @Column(name="symptoms")
    private String symptoms;

    @Column(name="diagnosis")
    private String diagnosis;

    @Column(name="prescription")
    private String prescription;

    @Column(name="notes")
    private String notes;

    public long getVisitId(){
        return visitId;
    }
    public Patient getPatient(){
        return patient;
    }
    public void setPatient(Patient patient){
        this.patient=patient;
    }
    public Doctor getDoctor(){
        return doctor;
    }
    public void setDoctor(Doctor doctor){
        this.doctor=doctor;
    }
    public Appointment getAppointment(){
        return appointment;
    }
    public void setAppointment(Appointment appointment){
        this.appointment=appointment;
    }
    public LocalDateTime getVisitTime(){
        return visitTime;
    }
    public void setVisitTime(LocalDateTime visitTime){
        this.visitTime=visitTime;
    }
    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight){
        this.weight=weight;
    }
    public double getHeight(){
        return height;
    }
    public void setHeight(double height){
        this.height=height;
    }
    public String getBloodPressure(){
        return bloodPressure;
    }
    public void setBloodPressure(String bloodPressure){
        this.bloodPressure=bloodPressure;
    }
    public String getSymptoms(){
        return symptoms;
    }
    public void setSymptoms(String symptoms){
        this.symptoms=symptoms;
    }
    public String getDiagnosis(){
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis){
        this.diagnosis=diagnosis;
    }
    public String getPrescription(){
        return prescription;
    }
    public void setPrescription(String prescription){
        this.prescription=prescription;
    }
    public String getNotes(){
        return notes;
    }
    public void setNotes(String notes){
        this.notes=notes;
    }
}