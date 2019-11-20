package com.thp.spring.projetfinal.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thp.spring.projetfinal.dto.ModeleDTO;
import com.thp.spring.projetfinal.entities.ModeleEntity;
import com.thp.spring.projetfinal.helper.ModelMapperConverter;
import com.thp.spring.projetfinal.repository.ModelRepository;
import com.thp.spring.projetfinal.service.ModelService;

@Service
public class ModelServiceImp implements ModelService{
	
	@Autowired
	ModelRepository modelRepository;

	@Override
	public ModeleDTO addModel(ModeleDTO modelDTO) {
ModeleEntity modelEntity = ModelMapperConverter.converToEntity(modelDTO, ModeleEntity.class);
		return ModelMapperConverter.converToDTO(modelRepository.save(modelEntity), ModeleDTO.class);
	}

	@Override
	public ModeleDTO findById(Long id) {
		ModeleEntity modelEntity = modelRepository.findById(id).orElse(null);
		return ModelMapperConverter.converToDTO(modelEntity, ModeleDTO.class);
	}

	@Override
	public List<ModeleDTO> findAll() {
		List<ModeleEntity> modelEntities = modelRepository.findAll();
		return ModelMapperConverter.convertAllToDTO(modelEntities, ModeleDTO.class);
	}

	@Override
	public void deleleModel(Long id) {
		modelRepository.deleteById(id);		
	}

}
