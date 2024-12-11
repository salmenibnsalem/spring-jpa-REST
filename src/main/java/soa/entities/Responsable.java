package soa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Responsable {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 50)
	private String nom;
	
	@Column(length = 50)
	private String prenom;
		
	@OneToOne (mappedBy = "responsable")
	private Stock stock;

	public Responsable(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	@Override
	public String toString() {
		return "Responsable [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", stock=" + stock + "]";
	}
	public Responsable(String nom, String prenom, Stock stock) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.stock = stock;
	}
	public Responsable() {
		super();
		// TODO Auto-generated constructor stub
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
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
}
