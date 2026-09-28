package com.example.healthcare.dto;

public class LoginResponseDTO{

    private long userId;
    private String email;
    private String role;

    public long getUserId(){
        return userId;
    }
    public void setUserId(long userId){
        this.userId=userId;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role=role;
    }
}