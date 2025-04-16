package formation_sopra.Refuge.rest.request;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import formation_sopra.Refuge.model.Animal;

public class AnimalRequest {
	private Integer id;
	private String nom;
	private String race;
	private LocalDate naissance;
	private String description;
	
	public AnimalRequest() {
		super();	}

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
	
	public static Animal convert(AnimalRequest animalRequest) {
		Animal animal = new Animal();
		
		BeanUtils.copyProperties(animalRequest, animal);

		
		return animal;
	}
}
