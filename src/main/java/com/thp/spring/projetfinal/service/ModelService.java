package com.thp.spring.projetfinal.service;

import java.util.List;

import com.thp.spring.projetfinal.dto.ModeleDTO;

public interface ModelService {

	ModeleDTO addModel(ModeleDTO modelDTO);
	
	ModeleDTO findById(Long id);
	
	List<ModeleDTO> findAll();
	
	void deleleModel(Long id);
	
}
