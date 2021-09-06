package com.app.carouts.modele;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Table(name = "voiture")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)
public class Voiture implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String nom;
	@NotNull
	private String kilometrage;
	@NotNull
	private String immatriculation;
	
	
	
	public Voiture() {
		super();
	}

	public Voiture(Integer id, String nom, String kilometrage, String immatriculation) {
		super();
		this.id = id;
		this.nom = nom;
		this.kilometrage = kilometrage;
		this.immatriculation = immatriculation;
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

	public String getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(String kilometrage) {
		this.kilometrage = kilometrage;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	@Override
	public String toString() {
		return "Voiture [id=" + id + ", nom=" + nom + ", kilometrage=" + kilometrage + ", immatriculation="
				+ immatriculation + "]";
	}
	
	
}
