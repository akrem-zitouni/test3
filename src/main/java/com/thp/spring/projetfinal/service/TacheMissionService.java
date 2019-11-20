package com.thp.spring.projetfinal.service;

import java.util.List;

import com.thp.spring.projetfinal.dto.TacheMissionDTO;

public interface TacheMissionService {
	

	TacheMissionDTO addTask(TacheMissionDTO modelDTO);
	TacheMissionDTO findById(Long id);

	List<TacheMissionDTO> findAll();
	List<TacheMissionDTO> getTacheMissionByUtilisateurId (Long idUser);
}


