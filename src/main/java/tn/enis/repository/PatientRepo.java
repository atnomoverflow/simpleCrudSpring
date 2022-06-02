package tn.enis.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import tn.enis.model.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long> {

}
