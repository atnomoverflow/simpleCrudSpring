package tn.enis.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.enis.model.Consultation;

import java.util.List;
@Repository
public interface ConsultationRepo extends JpaRepository<Consultation, Long> {

    @Query("FROM Consultation WHERE cin = ?1 ")
    List<Consultation> findAllByCin(int cin);


}
