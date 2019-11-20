package com.thp.spring.projetfinal.service;

import java.util.List;

import com.thp.spring.projetfinal.dto.UtilisateurDTO;

public interface UtilisateurService {

	UtilisateurDTO addUtilisateur(UtilisateurDTO utilisateurDTO);

	UtilisateurDTO findById(Long id);

	List<UtilisateurDTO> findAll();

	UtilisateurDTO findByPseudo(String pseudo);

	void deleteUtilisateur(Long id);

	List<UtilisateurDTO>findByManagerId(Long id);
	List<UtilisateurDTO>findByRoleId(Long id);
	List<UtilisateurDTO> findCollaborateursOfManager(String pseudo);

	List<UtilisateurDTO> findCollaborateursAndManagers();

	List<UtilisateurDTO> findManagers();

}
