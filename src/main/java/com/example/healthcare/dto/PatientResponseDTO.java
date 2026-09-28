package com.example.healthcare.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PatientResponseDTO{

    private long patientId;
    private String name;
    private String email;
    private String mobileNo;
    private String address;
    private String bloodGroup;
    private LocalDate birthDate;
    private String gender;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public long getPatientId(){
        return patientId;
    }
    public  void setPatientId(long patientId){
        this.patientId=patientId;
    }
    public String getName(){
        return name;
    }
    public  void setName(String name){
        this.name=name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getMobileNo(){
        return mobileNo;
    }
    public void setMobileNo(String mobileNo){
        this.mobileNo=mobileNo;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getBloodGroup(){
        return bloodGroup;
    }
    public void setBloodGroup(String bloodGroup){
        this.bloodGroup=bloodGroup;
    }
    public LocalDate getBirthDate(){
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate){
        this.birthDate=birthDate;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
}