package com.thp.spring.projetfinal.service;

import java.util.List;

import com.thp.spring.projetfinal.dto.TacheModeleDTO;

public interface TaskModeleService {
	TacheModeleDTO ajoutTaskModele(TacheModeleDTO taskModeleDTO);

	TacheModeleDTO findById(Long id);

	List<TacheModeleDTO> findAll();

	void deleteTaskModele(Long id);
	
	TacheModeleDTO findTaskModeleByNom(String nom);
}
