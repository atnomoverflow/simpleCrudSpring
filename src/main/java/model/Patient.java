package model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import javax.persistence.*;
import java.util.Date;
    @Data
    @Entity
    @Table(name = "patient")
    public class Patient {

        @Id
        private int cin;

        private String nom;

        private String prenom;

        private String addresse;

        @JsonFormat(locale="tn", timezone="GMT+1", pattern="yyyy-MM-dd")
        private Date dateNaissance;
        private int tel;



        public Patient(int cin, String nom, String prenom, String addresse, Date dateNaissance, int tel) {
            this.cin = cin;
            this.nom = nom;
            this.prenom = prenom;
            this.addresse = addresse;
            this.dateNaissance = dateNaissance;
            this.tel = tel;
        }
        public Patient(){}

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "nom = " + nom + ", " +
                    "prenom = " + prenom + ")";
        }
    }





