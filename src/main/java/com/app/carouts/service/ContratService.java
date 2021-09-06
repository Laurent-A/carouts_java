package com.app.carouts.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.carouts.dao.ContratDao;
import com.app.carouts.modele.Contrat;
import comp.app.carouts.exception.ApiNotFoundException;

@Service
public class ContratService {
	
	@Autowired
	public ContratDao contratDao;
	
	public List<Contrat> listeContrats(){
		List<Contrat>contrats= this.contratDao.findAll();
		return contrats;
	}
	
	public List<Contrat> listeContratsParVoiture(Integer id){
		return this.contratDao.findByVoiture(id);
	}
	
	public Contrat afficherContrat(Integer id) {
		return contratDao.findById(id).orElseThrow(() -> new ApiNotFoundException("contrat", "id", id));
	}
	
	public Contrat ajouterContrat(Contrat contrat) {
		contrat.setDateCreation(LocalDateTime.now());
		return contratDao.save(contrat);
	}
	
	@Transactional
	public Contrat modifierContrat(Integer id, Contrat contratDetails) {
		Contrat contrat = contratDao.findById(id).orElseThrow(() -> new ApiNotFoundException("contrat", "id", id));
		
		contrat.setNom(contratDetails.getNom());
		contrat.setDateCreation(contratDetails.getDateCreation());
		contrat.setModele(contratDetails.getModele());
		contrat.setNomPrestataire(contratDetails.getNomPrestataire());
		contrat.setCommentaire(contratDetails.getCommentaire());
		contrat.setPrix(contratDetails.getPrix());
		contrat.setProduit(contratDetails.getProduit());
		contrat.setVoiture(contrat.getVoiture());
		
		Contrat modifContrat = contratDao.save(contrat);
		
		return modifContrat;
	}
	@Transactional
	public void suppressionContrat(Integer id) {
		Contrat contrat = contratDao.findById(id).orElseThrow(() -> new ApiNotFoundException("contrat", "id", id));
		contratDao.delete(contrat);
	}
	
	public Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
	    return Timestamp.valueOf(dateToConvert);
	}

}
