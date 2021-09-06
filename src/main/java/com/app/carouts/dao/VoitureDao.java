package com.app.carouts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.carouts.modele.Voiture;

@Repository
public interface VoitureDao extends JpaRepository<Voiture, Integer>{

}
