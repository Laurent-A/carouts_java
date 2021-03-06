package com.app.carouts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.carouts.modele.Produit;

@Repository
public interface ProduitDao extends JpaRepository<Produit, Integer>{

}
