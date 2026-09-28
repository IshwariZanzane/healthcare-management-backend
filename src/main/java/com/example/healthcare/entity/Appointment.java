package com.example.healthcare.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="appointments")
public class Appointment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="appmt_id")
    private long appmtId;

    @ManyToOne
    @JoinColumn(name="patient_id",nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="doctor_id",nullable = false)
    private Doctor doctor;

    @Column(name="start_time",nullable = false)
    private LocalDateTime startTime;

    @Column(name="end_time",nullable = false)
    private LocalDateTime endTime;

    @Column(name="token_number",nullable = false)
    private int tokenNumber;

    @Column(name="reason")
    private String reason;

    @Column(name="status",nullable = false)
    private String status;

    public long getAppmtId(){
        return appmtId;
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
    public LocalDateTime getStartTime(){
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime){
        this.startTime=startTime;
    }
    public LocalDateTime getEndTime(){
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime){
        this.endTime=endTime;
    }
    public int getTokenNumber(){
        return tokenNumber;
    }
    public void setTokenNumber(int tokenNumber){
        this.tokenNumber=tokenNumber;
    }
    public String getReason(){
        return reason;
    }
    public void setReason(String reason){
        this.reason=reason;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }
}
