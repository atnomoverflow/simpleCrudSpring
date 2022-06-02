package tn.enis.service;
import tn.enis.model.Patient;
import tn.enis.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

	@Autowired
	private PatientRepo patientRepo;

	public Patient addPatient(Patient patient) {
		patient.setId(Long.parseLong(UUID.randomUUID().toString()));
		return patientRepo.save(patient);

	}

	public List<Patient> findAllPatients() {
		return patientRepo.findAll();
	}

	public Patient updatePatient(Patient patient) {
		return patientRepo.save(patient);
	}

	public Patient findPatientById(Long id) {
		return patientRepo.findById(id).get();
	}

	public void deletePatient(Long id) {
		if(patientRepo.findById(id).isPresent())
			patientRepo.deleteById(id);
		else
			System.err.println("ID NotFound");
	}

}