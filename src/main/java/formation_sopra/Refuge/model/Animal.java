package formation_sopra.Refuge.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="animal")
public class Animal{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String race;
	private LocalDate naissance;
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Statut status;
	
	@Lob
	private byte[] image;
	
	public Animal() {}
	
	public Animal(String nom, String race, LocalDate naissance, String description) {
		this.nom = nom;
		this.race = race;
		this.naissance = naissance;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public LocalDate getNaissance() {
		return naissance;
	}
	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Statut getStatus() {
		return status;
	}

	public void setStatus(Statut status) {
		this.status = status;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nom=" + nom + ", race=" + race + ", naissance=" + naissance + ", description=" + description
				+ ", status=" + status + "]";
	}
}
