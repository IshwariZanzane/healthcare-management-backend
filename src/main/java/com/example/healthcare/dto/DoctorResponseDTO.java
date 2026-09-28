package com.example.healthcare.dto;

public class DoctorResponseDTO{

    private long doctorId;
    private long userId;
    private String name;
    private String department;
    private String speciality;
    private String education;
    private String mobileNo;

    public long getUserId(){
        return userId;
    }
    public void setUserId(long userId){
        this.userId=userId;
    }
    public long getDoctorId(){
        return doctorId;
    }
    public void setDoctorId(long doctorId){
        this.doctorId=doctorId;
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
    public void setMobileNo(String mobileNo){this.mobileNo=mobileNo;
    }

}