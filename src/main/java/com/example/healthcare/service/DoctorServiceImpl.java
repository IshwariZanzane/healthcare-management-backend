package com.example.healthcare.service;

import com.example.healthcare.dto.DoctorRequestDTO;
import com.example.healthcare.dto.DoctorResponseDTO;
import com.example.healthcare.entity.Doctor;
import com.example.healthcare.entity.User;
import com.example.healthcare.repository.DoctorRepository;
import com.example.healthcare.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService{

    private DoctorRepository doctorRepository;
    private UserRepository userRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository, UserRepository userRepository){
        this.doctorRepository=doctorRepository;
        this.userRepository=userRepository;
    }

    @Override
    public List<DoctorResponseDTO> getAllDoctors(){
        List<Doctor> doctors=doctorRepository.findAll();

        return doctors.stream()
                .map(doctor -> {DoctorResponseDTO response=new DoctorResponseDTO();
                response.setDoctorId(doctor.getDoctorId());
                response.setUserId(doctor.getUser().getUserId());
                response.setName(doctor.getName());
                response.setDepartment(doctor.getDepartment());
                response.setSpeciality(doctor.getSpeciality());
                response.setEducation(doctor.getEducation());
                response.setMobileNo(doctor.getMobileNo());
                return response;
                }).toList();
    }

    @Override
    public DoctorResponseDTO createDoctor(DoctorRequestDTO request){
        Doctor doctor=new Doctor();
        User user=userRepository.findById(request.getUserId())
                        .orElseThrow(()->new IllegalArgumentException("user doesn't exist."));
        doctor.setUser(user);
        doctor.setName(request.getName());
        doctor.setDepartment(request.getDepartment());
        doctor.setSpeciality(request.getSpeciality());
        doctor.setEducation(request.getEducation());
        doctor.setMobileNo(request.getMobileNo());

        Doctor savedDoctor=doctorRepository.save(doctor);

        DoctorResponseDTO response=new DoctorResponseDTO();
        response.setDoctorId(savedDoctor.getDoctorId());
        response.setUserId(savedDoctor.getUser().getUserId());
        response.setName(savedDoctor.getName());
        response.setDepartment(savedDoctor.getDepartment());
        response.setSpeciality(savedDoctor.getSpeciality());
        response.setEducation(savedDoctor.getEducation());
        response.setMobileNo(savedDoctor.getMobileNo());

        return response;
    }

    @Override
    public DoctorResponseDTO getDoctorById(long doctorId){
        Doctor doctor=doctorRepository.findById(doctorId)
                .orElseThrow(()->new IllegalArgumentException("Doctor Doesn't Exist."));

        DoctorResponseDTO response=new DoctorResponseDTO();
        response.setDoctorId(doctor.getDoctorId());
        response.setUserId(doctor.getUser().getUserId());
        response.setName(doctor.getName());
        response.setDepartment(doctor.getDepartment());
        response.setSpeciality(doctor.getSpeciality());
        response.setEducation(doctor.getEducation());
        response.setMobileNo(doctor.getMobileNo());

        return response;
    }

    @Override
    public DoctorResponseDTO updateDoctor(long doctorId, DoctorRequestDTO request) {
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        if (doctor.isPresent()) {
            User user = userRepository.findById(request.getUserId())
                    .orElseThrow(() -> new IllegalArgumentException("User Doesn't Exist."));;

            Doctor existingDoctor = doctor.get();
            existingDoctor.setUser(user);
            existingDoctor.setName(request.getName());
            existingDoctor.setDepartment(request.getDepartment());
            existingDoctor.setSpeciality(request.getSpeciality());
            existingDoctor.setEducation(request.getEducation());
            existingDoctor.setMobileNo(request.getMobileNo());

            Doctor savedDoctor = doctorRepository.save(existingDoctor);

            DoctorResponseDTO response = new DoctorResponseDTO();
            response.setDoctorId(savedDoctor.getDoctorId());
            response.setUserId(savedDoctor.getUser().getUserId());
            response.setName(savedDoctor.getName());
            response.setDepartment(savedDoctor.getDepartment());
            response.setSpeciality(savedDoctor.getSpeciality());
            response.setEducation(savedDoctor.getEducation());
            response.setMobileNo(savedDoctor.getMobileNo());

            return response;
        }
        throw new IllegalArgumentException("Doctor Doesn't Exist");
    }

    @Override
    public void deleteDoctor(long doctorId){
        Optional<Doctor> doctor =doctorRepository.findById(doctorId);
        if(doctor.isPresent()){
            Doctor existingDoctor=doctor.get();
            doctorRepository.delete(existingDoctor);

            return;
        }
        throw new IllegalArgumentException("Doctor Doesn't Exist.");

    }



}