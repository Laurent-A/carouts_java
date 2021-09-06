package com.app.carouts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.carouts.modele.Voiture;
import com.app.carouts.service.VoitureService;

@RestController
@RequestMapping("/carouts")
@CrossOrigin("*")
public class VoitureController {
	
	@Autowired
	private VoitureService voitureService;
	
	@GetMapping(value="/voiture", produces= {"application/json"})
	public List<Voiture> listeVoiture(){
		return this.voitureService.listeVoitures();
	}

	@GetMapping(value="/voiture/{id}")
	public Voiture afficherVoiture(@PathVariable(value = "id") Integer id) {
		return voitureService.afficherVoiture(id);
	}
	
	@PostMapping("/voiture")
	public Voiture ajouterVoiture(@RequestBody Voiture voiture) {
	    return voitureService.ajouterVoiture(voiture);
	}
	
	@PutMapping("/voiture/{id}")
	public Voiture modifierVoiture(@PathVariable(value = "id") Integer id, @RequestBody Voiture voiture) {
	    return voitureService.modifierVoiture(id, voiture);
	}
	
	@DeleteMapping("/voiture/{id}")
	public ResponseEntity<?> suppressionVoiture(@PathVariable(value = "id") Integer id) {
		voitureService.suppressionVoiture(id);
		return ResponseEntity.ok().build();
	}

}
