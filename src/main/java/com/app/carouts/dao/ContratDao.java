package com.app.carouts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.carouts.modele.Contrat;

@Repository
public interface ContratDao extends JpaRepository<Contrat, Integer>{
	
	@Query(value="select * from contrat e where e.voiture=?1 ORDER BY date_creation ASC", nativeQuery= true)
	List<Contrat> findByVoiture(Integer id);

}
