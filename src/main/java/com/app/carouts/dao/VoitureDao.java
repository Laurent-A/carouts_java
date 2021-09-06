package com.app.carouts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.carouts.modele.Voiture;

@Repository
public interface VoitureDao extends JpaRepository<Voiture, Integer>{

	@Query(value="delete from Contrat e where e.voiture.id=?1")
	@Modifying
	public void supprimerContratParVoiture(Integer id_vehicule);
}
