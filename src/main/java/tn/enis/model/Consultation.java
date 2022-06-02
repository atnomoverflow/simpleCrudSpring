package tn.enis.model;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.lang.invoke.CallSite;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "consultation")
public class Consultation {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_consultation", nullable = false)
        private Long id;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "id_patient", nullable = false)
        private Patient patient;

        @JsonFormat(locale="tn", timezone="GMT+1", pattern="yyyy-MM-dd")
        private Date dateConsultation;

        @OneToMany(cascade = CascadeType.ALL)
        private List<Medicament> medicaments;

        private String description;

        public Consultation() {
        }

        public Consultation(Long id, Patient patient, Date dateConsultation, List<Medicament> medicaments, String description) {
            this.id = id;
            this.patient = patient;
            this.dateConsultation = dateConsultation;
            this.medicaments = medicaments;
            this.description = description;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Patient getPatient() {
            return patient;
        }

        public void setPatient(Patient patient) {
            this.patient = patient;
        }

        public Date getDateConsultation() {
            return dateConsultation;
        }

        public void setDateConsultation(Date dateConsultation) {
            this.dateConsultation = dateConsultation;
        }

        @OneToMany
        public List<Medicament> getMedicaments() {
            return medicaments;
        }

        public void setMedicaments(List<Medicament> medicaments) {
            this.medicaments = medicaments;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }



