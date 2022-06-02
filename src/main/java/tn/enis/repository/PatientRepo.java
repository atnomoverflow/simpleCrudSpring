package tn.enis.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enis.model.Patient;
@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {

}
