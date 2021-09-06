package com.app.carouts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.carouts.dao.ProduitDao;
import com.app.carouts.modele.Produit;
import comp.app.carouts.exception.ApiNotFoundException;

@Service
public class ProduitService {
	
	@Autowired
	public ProduitDao produitDao;
	
	public List<Produit> listeProduits(){
		return this.produitDao.findAll();
	}
	
	public Produit afficherProduit(Integer id) {
		return produitDao.findById(id).orElseThrow(() -> new ApiNotFoundException("produit", "id", id));
	}

}
