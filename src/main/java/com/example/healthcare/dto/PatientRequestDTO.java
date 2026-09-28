package com.example.healthcare.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class PatientRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Mobile number is required")
    private String mobileNo;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Blood group is required")
    private String bloodGroup;

    @NotNull(message = "Birth date is required")
    private LocalDate birthDate;

    @NotBlank(message = "Gender is required")
    private String gender;

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }

    public String getMobileNo(){ return mobileNo; }
    public void setMobileNo(String mobileNo){ this.mobileNo = mobileNo; }

    public String getAddress(){ return address; }
    public void setAddress(String address){ this.address = address; }

    public String getBloodGroup(){ return bloodGroup; }
    public void setBloodGroup(String bloodGroup){ this.bloodGroup = bloodGroup; }

    public LocalDate getBirthDate(){ return birthDate; }
    public void setBirthDate(LocalDate birthDate){ this.birthDate = birthDate; }

    public String getGender(){ return gender; }
    public void setGender(String gender){ this.gender = gender; }
}