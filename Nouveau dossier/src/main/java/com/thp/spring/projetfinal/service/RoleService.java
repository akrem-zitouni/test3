package com.thp.spring.projetfinal.service;

import java.util.List;

import com.thp.spring.projetfinal.dto.RoleDTO;
import com.thp.spring.projetfinal.util.Libelle;

public interface RoleService {

	RoleDTO addRole(RoleDTO roleDTO);

	RoleDTO findById(Long id);

	List<RoleDTO> findAll();



	RoleDTO updateRole(Long id, RoleDTO roleDTO);
	
	RoleDTO findRolebyLibelle(Libelle libelle);
}
