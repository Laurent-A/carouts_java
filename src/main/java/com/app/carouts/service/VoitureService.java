package com.app.carouts.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.carouts.dao.VoitureDao;
import com.app.carouts.modele.Voiture;
import comp.app.carouts.exception.ApiNotFoundException;

@Service
public class VoitureService {
	
	@Autowired
	public VoitureDao voitureDao;
	
	public List<Voiture> listeVoitures(){
		return this.voitureDao.findAll();
	}
	
	public Voiture afficherVoiture(Integer id) {
		return voitureDao.findById(id).orElseThrow(() -> new ApiNotFoundException("voiture", "id", id));
	}
	
	public Voiture ajouterVoiture(Voiture voiture) {
		return voitureDao.save(voiture);
	}
	
	@Transactional
	public Voiture modifierVoiture(Integer id, Voiture voitureDetails) {
		Voiture voiture = voitureDao.findById(id).orElseThrow(() -> new ApiNotFoundException("voiture", "id", id));
		
		voiture.setImmatriculation(voitureDetails.getImmatriculation());
		voiture.setNom(voitureDetails.getNom());
		voiture.setKilometrage(voitureDetails.getKilometrage());
		
		Voiture modifVoiture = voitureDao.save(voiture);
		
		return modifVoiture;
	}
	@Transactional
	public void suppressionVoiture(Integer id) {
		Voiture voiture = voitureDao.findById(id).orElseThrow(() -> new ApiNotFoundException("voiture", "id", id));
		voitureDao.delete(voiture);
	}
	
	@Transactional
	public void supprimerContratParVoiture(Integer id) {
		voitureDao.supprimerContratParVoiture(id);
	}
	

}
