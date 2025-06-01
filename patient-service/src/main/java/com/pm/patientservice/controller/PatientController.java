package com.pm.patientservice.controller;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
@Tag(name = "Patient Controller" , description = "Managing Patients with API")
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public List<PatientResponseDTO> getPatients(){
        return patientService.getPatients();
    }

    @PostMapping
    public PatientResponseDTO createPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO){

        return patientService.createPatient(patientRequestDTO);
    }

    @PutMapping("/{id}")
    public PatientResponseDTO updatePatient(@PathVariable UUID id,
                                            @Valid @RequestBody PatientRequestDTO patientRequestDTO){

        return patientService.updatePatient(id ,patientRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable UUID id){
        patientService.deletePatient(id);
    }

}
