package com.app.carouts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.carouts.modele.Produit;
import com.app.carouts.service.ProduitService;

@RestController
@RequestMapping("/carouts")
@CrossOrigin("*")
public class ProduitController {
	
	@Autowired
	private ProduitService produitService;
	
	@GetMapping(value="/produit", produces= {"application/json"})
	public List<Produit> listeProduits(){
		return this.produitService.listeProduits();
	}

	@GetMapping(value="/produit/{id}")
	public Produit afficherProduit(@PathVariable(value = "id") Integer id) {
		return produitService.afficherProduit(id);
	}

}
