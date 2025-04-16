package formation_sopra.Refuge.model;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="produit")
public class Produit{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBasic.class)
	private Integer id;
	@JsonView(Views.ViewBasic.class)
	private String libelle;
	@JsonView(Views.ViewBasic.class)
	private String description;
	@JsonView(Views.ViewBasic.class)
	private Double prix;
	@JsonView(Views.ViewBasic.class)
	private Integer stock;
	
	public Produit() {}
	
	public Produit(String libelle, String description, Double prix, Integer stock) {
		this.libelle = libelle;
		this.description = description;
		this.prix = prix;
		this.stock = stock;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", libelle=" + libelle + ", description=" + description + ", prix=" + prix
				+ ", stock=" + stock + "]";
	}
}
