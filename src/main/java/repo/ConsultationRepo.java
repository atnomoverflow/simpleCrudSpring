package repo;
import model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConsultationRepo extends JpaRepository<Consultation, Long> {

    @Query("FROM Consultation WHERE cin = ?1 ")
    List<Consultation> findAllByCin(int cin);


}
