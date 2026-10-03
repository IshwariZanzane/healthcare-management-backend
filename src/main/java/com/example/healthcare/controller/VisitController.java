package com.example.healthcare.controller;

import com.example.healthcare.dto.VisitRequestDTO;
import com.example.healthcare.dto.VisitResponseDTO;
import com.example.healthcare.service.VisitService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("")
    public VisitResponseDTO createVisit(@RequestBody VisitRequestDTO request){
        return visitService.createVisit(request);
    }

    @PutMapping("/{visitId}")
    public VisitResponseDTO updateVisit(@PathVariable long visitId, @RequestBody VisitRequestDTO request){
        return visitService.updateVisit(visitId,request);
    }
}