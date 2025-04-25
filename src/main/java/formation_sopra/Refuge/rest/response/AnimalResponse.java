package formation_sopra.Refuge.rest.response;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonView;

import formation_sopra.Refuge.model.Animal;
import formation_sopra.Refuge.model.Views;


public class AnimalResponse {
	@JsonView(Views.ViewAnimal.class)
	private Integer id;
	@JsonView(Views.ViewAnimal.class)
	private String nom;
	@JsonView(Views.ViewAnimal.class)
	private String race;
	@JsonView(Views.ViewAnimal.class)
	private LocalDate naissance;
	@JsonView(Views.ViewAnimal.class)
	private String description;
	@JsonView(Views.ViewAnimal.class)
	private Integer idWorker;
	
	public AnimalResponse() {
		super();
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
	
	public Integer getIdWorker() {
		return idWorker;
	}

	public void setIdWorker(Integer idWorker) {
		this.idWorker = idWorker;
	}

	public static AnimalResponse convert(Animal animal) {
		AnimalResponse animalResponse = new AnimalResponse();
		BeanUtils.copyProperties(animal, animalResponse);
		return animalResponse; 
	}
}
