package tn.enis.controller;


import tn.enis.model.Patient;
import tn.enis.repository.PatientRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {

    @Autowired
    private PatientRepo patientRepo;

    @PostMapping("/")
    @ResponseBody
    ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
        patientRepo.save(patient);
        return ResponseEntity.ok(patient);
    }
    @GetMapping("/")
    @ResponseBody
    ResponseEntity<Patient> getAllPatient(@RequestBody Patient patient){
        Patient result = patientRepo.findById(patient.getId()).get();
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/")
    ResponseEntity<HttpStatus> deletePatient(@RequestBody Patient patient){
        patientRepo.deleteById(patient.getId());
        return ResponseEntity.ok(HttpStatus.OK);
    }

}