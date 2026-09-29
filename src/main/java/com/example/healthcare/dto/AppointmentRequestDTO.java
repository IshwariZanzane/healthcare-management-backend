package com.example.healthcare.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class AppointmentRequestDTO{

    private long patientId;

    private long doctorId;

    @NotNull(message = "Start time is required.")
    private LocalDateTime startTime;

    @NotNull(message = "End time is required. ")
    private LocalDateTime endTime;

    private String reason;

    @NotNull(message = "status is required.")
    private AppointmentStatus status;

    public enum AppointmentStatus {
        SCHEDULED,
        COMPLETED,
        CANCELLED,
        NO_SHOW
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
    public String getReason(){
        return reason;
    }
    public void setReason(String reason){
        this.reason=reason;
    }
    public AppointmentStatus getStatus(){
        return status;
    }
    public void setStatus(AppointmentStatus status){
        this.status=status;
    }
}