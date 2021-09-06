package com.app.carouts.controller;

import java.util.List;
import java.util.Optional;

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

import com.app.carouts.modele.Contrat;
import com.app.carouts.service.ContratService;

@RestController
@RequestMapping("/carouts")
@CrossOrigin("*")
public class ContratController {
	
	@Autowired
	private ContratService contratService;
	
	@GetMapping(value="/contrat", produces= {"application/json"})
	public List<Contrat> listeContrats(){
		return this.contratService.listeContrats();
	}
	
	@GetMapping(value="/contrat/voiture/{id}", produces= {"application/json"})
	public List<Contrat> listeContratsParVoiture(@PathVariable(value = "id") Integer id){
		return this.contratService.listeContratsParVoiture(id);
	}

	@GetMapping(value="/contrat/{id}")
	public Contrat afficherContrat(@PathVariable(value = "id") Integer id) {
		return contratService.afficherContrat(id);
	}
	
	@PostMapping("/contrat")
	public Contrat ajouterContrat(@RequestBody Contrat contrat) {
	    return contratService.ajouterContrat(contrat);
	}
	
	@PutMapping("/contrat/{id}")
	public Contrat modifierContrat(@PathVariable(value = "id") Integer id, @RequestBody Contrat contrat) {
	    return contratService.modifierContrat(id, contrat);
	}
	
	@DeleteMapping("/contrat/{id}")
	public ResponseEntity<?> suppressionContrat(@PathVariable(value = "id") Integer id) {
		contratService.suppressionContrat(id);
		return ResponseEntity.ok().build();
	}

}
