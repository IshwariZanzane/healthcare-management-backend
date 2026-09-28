package com.example.healthcare.service;

import com.example.healthcare.dto.LoginRequestDTO;
import com.example.healthcare.dto.LoginResponseDTO;
import com.example.healthcare.dto.UserRequestDTO;
import com.example.healthcare.dto.UserResponseDTO;
import com.example.healthcare.entity.User;
import com.example.healthcare.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public List<UserResponseDTO> getAllUsers(){
        List<User> users=userRepository.findAll();
        return users.stream()
                .map(user->{UserResponseDTO response = new UserResponseDTO();
            response.setUserId(user.getUserId());
            response.setEmail(user.getEmail());
            response.setRole(user.getRole());
            return response;
        }).toList();
    }

    @Override
    public UserResponseDTO getUserById(long userId){
        User user=userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("User Doesn't exist"));

        UserResponseDTO response=new UserResponseDTO();
        response.setUserId(user.getUserId());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());

        return response;
    }

    @Override
    public UserResponseDTO createUser(@RequestBody UserRequestDTO request){
        User user=new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        User savedUser=userRepository.save(user);

        UserResponseDTO response=new UserResponseDTO();
        response.setUserId(savedUser.getUserId());
        response.setEmail(savedUser.getEmail());
        response.setRole(savedUser.getRole());

        return response;
    }

    @Override
    public UserResponseDTO updateUser(long userId, @RequestBody UserRequestDTO request) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setEmail(request.getEmail());
            existingUser.setRole(request.getRole());

            User savedUser = userRepository.save(existingUser);

            UserResponseDTO response = new UserResponseDTO();
            response.setEmail(savedUser.getEmail());
            response.setRole(savedUser.getRole());

            return response;
        }
        throw new IllegalArgumentException("User doesn't exist");
    }

    @Override
    public void deleteUser(long userId){
        Optional<User> user=userRepository.findById(userId);
        if(user.isPresent()){
            User existingUser=user.get();
            userRepository.delete(existingUser);

            return;
        }
        throw new IllegalArgumentException("Patient Doesnt exist");
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO request){
        Optional<User> userOptional=userRepository.findByEmail(request.getEmail());
        if(userOptional.isEmpty()){
            throw new IllegalArgumentException("Invalid email or password");
        }
        User user=userOptional.get();
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new IllegalArgumentException("Invalid email or password");
        }
        LoginResponseDTO response=new LoginResponseDTO();
        response.setUserId(user.getUserId());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());

        return response;
    }

}