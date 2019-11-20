package com.thp.spring.projetfinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thp.spring.projetfinal.entities.TacheMissionEntity;

public interface TacheMissionRepository extends JpaRepository<TacheMissionEntity, Long>{
	public List<TacheMissionEntity> getTacheMissionByUtilisateurId(Long idUser);
	
}
