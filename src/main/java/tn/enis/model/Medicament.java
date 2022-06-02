package tn.enis.model;
import javax.persistence.*;

@Entity
@Table(name = "medicament")
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_medicament", nullable = false)
    private Long id;

    private String nomMedicament;

    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;



    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomMedicament() {
        return nomMedicament;
    }

    public void setNomMedicament(String nomMedicament) {
        this.nomMedicament = nomMedicament;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

}
