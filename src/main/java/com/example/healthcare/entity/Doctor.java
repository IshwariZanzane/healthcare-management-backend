package com.example.healthcare.entity;

import jakarta.persistence.*;

@Entity
@Table(name="doctors")
public class Doctor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="doctor_id")
    private long doctorId;

    @OneToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="department")
    private String department;

    @Column(name="speciality")
    private String speciality;

    @Column(name="education")
    private String education;

    @Column(name="mobile_no")
    private String mobileNo;

    public long getDoctorId(){
        return doctorId;
    }
    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user=user;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department=department;
    }
    public String getSpeciality(){
        return speciality;
    }
    public void setSpeciality(String speciality){
        this.speciality=speciality;
    }
    public String getEducation(){
        return education;
    }
    public void setEducation(String education){
        this.education=education;
    }
    public String getMobileNo(){
        return mobileNo;
    }
    public void setMobileNo(String mobileNo){
        this.mobileNo=mobileNo;
    }
}