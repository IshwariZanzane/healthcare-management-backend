package com.example.healthcare.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="patients")
public class Patient{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="patient_id")
    private long patientId;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="mobile_no",nullable = false)
    private String mobileNo;

    @Column(name="address")
    private String address;

    @Column(name="blood_group")
    private String bloodGroup;

    @Column(name="birth_date",nullable = false)
    private LocalDate birthDate;

    @Column(name="gender",nullable = false)
    private String gender;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

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
    public long getPatientId(){
        return patientId;
    }
}