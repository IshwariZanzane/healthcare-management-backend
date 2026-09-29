package com.example.healthcare.dto;

import com.example.healthcare.entity.Doctor;
import com.example.healthcare.entity.Patient;

import java.time.LocalDateTime;

public class AppointmentResponseDTO{
    private long appmtId;
    private long patientId;
    private String patientName;
    private long doctorId;
    private String doctorName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int tokenNumber;
    private String reason;
    private String status;

    public long getAppmtId(){
        return appmtId;
    }
    public void setAppmtId(long appmtId){
        this.appmtId=appmtId;
    }
    public long getPatientId(){
        return patientId;
    }
    public void setPatientId(long  patientId){
        this.patientId=patientId;
    }
    public String getPatientName(){
        return patientName;
    }
    public void setPatientName(String patientName){
        this.patientName=patientName;
    }
    public long getDoctorId(){
        return doctorId;
    }
    public void setDoctorId(long doctorId){
        this.doctorId=doctorId;
    }
    public String getDoctorName(){
        return doctorName;
    }
    public void setDoctorName(String doctorName){
        this.doctorName=doctorName;
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