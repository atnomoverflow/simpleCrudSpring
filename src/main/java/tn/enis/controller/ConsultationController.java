package tn.enis.controller;

import tn.enis.model.Consultation;
import tn.enis.repository.ConsultationRepo;
import tn.enis.repository.PatientRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsultationController {

    @Autowired
    private ConsultationRepo consultationRepo;

    @Autowired
    private PatientRepo patientRepo;

    @GetMapping("/get-consult")
    ResponseEntity<List<Consultation>> findConsultation(@RequestParam int cin) {
        List<Consultation> result = consultationRepo.findAllByCin(cin);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("delete-consult")
    ResponseEntity<HttpStatus> deleteConsultation(@RequestParam long id) {
        consultationRepo.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("update-consult")
    ResponseEntity updateConsultation(@RequestParam long id, @RequestBody Consultation consultation) {
        Consultation oldConsultation = consultationRepo.findById(id).get();
        if (oldConsultation != consultation) {
//                consultationRepo.updateById(id, consultation);
            return ResponseEntity.ok(consultation);
        }
        return ResponseEntity.ok("not updated");
    }

    @PostMapping("new-consult")
    ResponseEntity<Consultation> createConsultation(@RequestBody Consultation consultation) {
//        int cin = consultation.getPatient().getCin();
//        if(patientRepo.existsById(cin)){
//            Consultation samePatientConsultation = new Consultation();
//        }
        consultationRepo.save(consultation);
        return ResponseEntity.ok(consultation);
    }
}