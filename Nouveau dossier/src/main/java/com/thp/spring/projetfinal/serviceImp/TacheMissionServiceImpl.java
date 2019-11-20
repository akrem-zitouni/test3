package com.thp.spring.projetfinal.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thp.spring.projetfinal.dto.TacheMissionDTO;
import com.thp.spring.projetfinal.entities.TacheMissionEntity;
import com.thp.spring.projetfinal.helper.ModelMapperConverter;
import com.thp.spring.projetfinal.repository.TacheMissionRepository;
import com.thp.spring.projetfinal.service.TacheMissionService;

@Service
public class TacheMissionServiceImpl implements TacheMissionService {

	@Autowired
	TacheMissionRepository tacheMissionRepository;

	@Override
	public TacheMissionDTO findById(Long id) {

		return null;
	}

	@Override
	public List<TacheMissionDTO> findAll() {
		List<TacheMissionEntity> tacheMissionEntity = tacheMissionRepository.findAll();
		return ModelMapperConverter.convertAllToDTO(tacheMissionEntity, TacheMissionDTO.class);
	}

	@Override
	public TacheMissionDTO addTask(TacheMissionDTO modelDTO) {
		TacheMissionEntity modelEntity = ModelMapperConverter.converToEntity(modelDTO, TacheMissionEntity.class);
		return ModelMapperConverter.converToDTO(tacheMissionRepository.save(modelEntity), TacheMissionDTO.class);
	}

	@Override
	public List<TacheMissionDTO> getTacheMissionByUtilisateurId(Long idUser) {
		List<TacheMissionEntity> tacheMissionEntity = tacheMissionRepository.getTacheMissionByUtilisateurId(idUser);
		return ModelMapperConverter.convertAllToDTO(tacheMissionEntity, TacheMissionDTO.class);
	}



	

}
