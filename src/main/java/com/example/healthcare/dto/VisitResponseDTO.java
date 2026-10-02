package com.example.healthcare.dto;

import java.time.LocalDateTime;

public class VisitResponseDTO{

    private long visitId;
    private long patientId;
    private long doctorId;
    private long appointmentId;
    private LocalDateTime visitTime;
    private double weight;
    private double height;
    private String bloodPressure;
    private String symptoms;
    private String diagnosis;
    private String prescription;
    private String notes;

    public long getVisitId(){
        return visitId;
    }
    public void setVisitId(long visitId){
        this.visitId=visitId;
    }

    public long getPatientId(){
        return patientId;
    }
    public void setPatientId(long patientId){
        this.patientId=patientId;
    }
    public long getDoctorId(){
        return doctorId;
    }
    public void setDoctorId(long doctorId){
        this.doctorId=doctorId;
    }
    public long getAppointmentId(){
        return appointmentId;
    }
    public void setAppointmentId(long appointmentId){
        this.appointmentId=appointmentId;
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