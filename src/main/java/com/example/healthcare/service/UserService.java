package com.example.healthcare.service;

import com.example.healthcare.dto.LoginRequestDTO;
import com.example.healthcare.dto.LoginResponseDTO;
import com.example.healthcare.dto.UserRequestDTO;
import com.example.healthcare.dto.UserResponseDTO;

import java.util.List;

public interface UserService{

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(long userId);

    UserResponseDTO createUser(UserRequestDTO request);

    UserResponseDTO updateUser(long userId, UserRequestDTO request);

    void deleteUser(long userId);

    LoginResponseDTO login(LoginRequestDTO request);
}