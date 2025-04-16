package formation_sopra.Refuge.rest.response;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonView;

import formation_sopra.Refuge.model.Produit;
import formation_sopra.Refuge.model.Views;

public class ProduitResponse {
	@JsonView(Views.ViewProduit.class)
	private Integer id;
	@JsonView(Views.ViewProduit.class)
	private String libelle;
	@JsonView(Views.ViewProduit.class)
	private String description;
	@JsonView(Views.ViewProduit.class)
	private Double prix;
	@JsonView(Views.ViewProduit.class)
	private Integer stock;

	public ProduitResponse() {
		super();
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

	public static ProduitResponse convert(Produit produit) {
		ProduitResponse produitResponse = new ProduitResponse();
		BeanUtils.copyProperties(produit, produitResponse);
		
		return produitResponse;
	}
}
