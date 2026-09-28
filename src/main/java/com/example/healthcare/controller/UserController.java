package com.example.healthcare.controller;

import com.example.healthcare.dto.LoginRequestDTO;
import com.example.healthcare.dto.LoginResponseDTO;
import com.example.healthcare.dto.UserRequestDTO;
import com.example.healthcare.dto.UserResponseDTO;
import com.example.healthcare.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController{

    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/users")
    public List<UserResponseDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public UserResponseDTO getUserById(@PathVariable long userId){
        return userService.getUserById(userId);
    }

    @PostMapping("/users")
    public UserResponseDTO createUser(@Valid @RequestBody UserRequestDTO request){
        return userService.createUser(request);
    }

    @PutMapping("/users/{userId}")
    public UserResponseDTO updateUser(@PathVariable long userId, @Valid @RequestBody UserRequestDTO request){
        return userService.updateUser(userId,request);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable long userId){
        userService.deleteUser(userId);
    }

    @PostMapping("/users/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO request){
        return userService.login(request);
    }
}
