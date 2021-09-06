package com.app.carouts.modele;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "contrat")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)
public class Contrat implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	private String nom;

	@NotNull
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDateTime dateCreation;
	
	@NotNull
	private String prix;

	private String nomPrestataire;
	
	private String modele;
	
	private String commentaire;
	
	@ManyToOne
	@JoinColumn( name="voiture" )
	private Voiture voiture;
	@ManyToOne
	@JoinColumn( name="referentiel_service" )
	private Produit produit;
	
	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contrat(Integer id, String nom, LocalDateTime dateCreation, String prix, String nomPrestataire, String modele,
			String commentaire, Voiture voiture, Produit produit) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateCreation = dateCreation;
		this.prix = prix;
		this.nomPrestataire = nomPrestataire;
		this.modele = modele;
		this.commentaire = commentaire;
		this.voiture = voiture;
		this.produit = produit;
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

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getNomPrestataire() {
		return nomPrestataire;
	}

	public void setNomPrestataire(String nomPrestataire) {
		this.nomPrestataire = nomPrestataire;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	

}
