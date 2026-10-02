package com.example.healthcare.controller;

import com.example.healthcare.dto.VisitResponseDTO;
import com.example.healthcare.service.VisitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/visits")
public class VisitController{
    private VisitService visitService;

    public VisitController(VisitService visitService){
        this.visitService=visitService;
    }

    @GetMapping("")
    public List<VisitResponseDTO> getAllVisit(){
        return visitService.getAllVisits();
    }
}