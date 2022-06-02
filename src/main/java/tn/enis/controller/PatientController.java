package tn.enis.controller;

import tn.enis.model.Patient;
import tn.enis.service.PatientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patient")
public class PatientController {
	@Autowired
	private PatientService patientService;

	@GetMapping("/")
	public List<Patient> getAllPatient() {
		List<Patient> patients = patientService.findAllPatients();
		return patients;
	}

	@GetMapping("/{id}")
	public Patient getPatientById(@PathVariable("id") Long id) {
		Patient patient = patientService.findPatientById(id);
		return patient;
	}

	@PostMapping("/")
	public Patient addPatient(@RequestBody Patient patient) {
		Patient newpatient = patientService.addPatient(patient);
		return newpatient;

	}

	@PutMapping("/update")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
		Patient updatepatient = patientService.updatePatient(patient);
		return new ResponseEntity<>(updatepatient, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public boolean deletePatient(@PathVariable("id") Long id) {
		patientService.deletePatient(id);
		return true;

	}
}