package com.thp.spring.projetfinal.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thp.spring.projetfinal.dto.RoleDTO;
import com.thp.spring.projetfinal.entities.RoleEntity;
import com.thp.spring.projetfinal.helper.ModelMapperConverter;
import com.thp.spring.projetfinal.repository.RoleRepository;
import com.thp.spring.projetfinal.service.RoleService;
import com.thp.spring.projetfinal.util.Libelle;

@Service
public class RoleServiceImp implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	@Override
	public RoleDTO addRole(RoleDTO roleDTO) {
		RoleEntity roleEntity = ModelMapperConverter.converToEntity(roleDTO,
				RoleEntity.class);
		return ModelMapperConverter.converToDTO(roleRepository.save(roleEntity), RoleDTO.class);

	}

	@Override
	public RoleDTO findById(Long id) {
				return null;
	}

	@Override
	public List<RoleDTO> findAll() {
		List<RoleEntity> role = roleRepository.findAll();
		return ModelMapperConverter.convertAllToDTO(role, RoleDTO.class);
	}



	@Override
	public RoleDTO updateRole(Long id, RoleDTO roleDTO) {
				return null;
	}

	@Override
	public RoleDTO findRolebyLibelle(Libelle libelle) {
		return ModelMapperConverter.converToDTO(roleRepository.findByLibelle(libelle), RoleDTO.class);
				
	}

}
