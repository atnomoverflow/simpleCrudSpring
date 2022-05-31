package ressource;


import model.Patient;
import repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientResource {

    @Autowired
    private PatientRepo patientRepo;

    @PostMapping("/new-patient")
    @ResponseBody
    ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
        patientRepo.save(patient);
        return ResponseEntity.ok(patient);
    }
    @GetMapping("/get-patient")
    @ResponseBody
    ResponseEntity<Patient> getPatient(@RequestBody Patient patient){
        Patient result = patientRepo.findById(patient.getCin()).get();
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/delete-patient")
    ResponseEntity<HttpStatus> deletePatient(@RequestBody Patient patient){
        patientRepo.deleteById(patient.getCin());
        return ResponseEntity.ok(HttpStatus.OK);
    }

}