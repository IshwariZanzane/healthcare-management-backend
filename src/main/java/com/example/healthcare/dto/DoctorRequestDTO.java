package com.example.healthcare.dto;

import jakarta.validation.constraints.NotBlank;

public class DoctorRequestDTO{

    private long userId;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Department is required")
    private String department;

    @NotBlank(message = "Speciality is required")
    private String speciality;

    @NotBlank(message = "Education is required")
    private String education;

    @NotBlank(message = "Mobile number is required")
    private String mobileNo;

    public long getUserId(){ return userId; }
    public void setUserId(long userId){ this.userId = userId; }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public String getDepartment(){ return department; }
    public void setDepartment(String department){ this.department = department; }

    public String getSpeciality(){ return speciality; }
    public void setSpeciality(String speciality){ this.speciality = speciality; }

    public String getEducation(){ return education; }
    public void setEducation(String education){ this.education = education; }

    public String getMobileNo(){ return mobileNo; }
    public void setMobileNo(String mobileNo){ this.mobileNo = mobileNo; }
}