package tn.enis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "patient")
public class Patient {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_patient", nullable = false)
    private Long id;

	private int cin;

	private String nom;

	private String prenom;

	private String addresse;

	@JsonFormat(locale = "tn", timezone = "GMT+1", pattern = "yyyy-MM-dd")
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

	public Patient() {
	}
	public int getCin() {
		return cin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addresse, cin, dateNaissance, nom, prenom, tel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(addresse, other.addresse) && cin == other.cin
				&& Objects.equals(dateNaissance, other.dateNaissance) && Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom) && tel == other.tel;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "nom = " + nom + ", " + "prenom = " + prenom + ")";
	}
}
