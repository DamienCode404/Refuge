package formation_sopra.Refuge.rest.request;

import java.time.LocalDate;
import java.util.Base64;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;

import formation_sopra.Refuge.model.Animal;

public class AnimalRequest {
	private Integer id;
	private String nom;
	private String race;
	private LocalDate naissance;
	private String description;
	private Integer idWorker;
	private String imageBase64;
	
	public AnimalRequest() {
		super();	}

	public String getImageBase64() {
		return imageBase64;
	}

	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
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

	public static Animal convert(AnimalRequest animalRequest) {
		Animal animal = new Animal();
		
		BeanUtils.copyProperties(animalRequest, animal);
		
		//Base64 vers byte 
		var b64 = animalRequest.getImageBase64();
		var split = Stream.of(b64.split(",")).toList().getLast();
		byte[] decode = Base64.getDecoder().decode(split);
		animal.setImage(decode);
		
		return animal;
	}
}
