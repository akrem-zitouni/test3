package com.thp.spring.projetfinal.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thp.spring.projetfinal.dto.TacheModeleDTO;
import com.thp.spring.projetfinal.entities.TacheModeleEntity;
import com.thp.spring.projetfinal.helper.ModelMapperConverter;
import com.thp.spring.projetfinal.repository.TaskModeleRepository;
import com.thp.spring.projetfinal.service.TaskModeleService;

@Service
public class TaskModeleServiceImpl implements TaskModeleService {
	@Autowired
	TaskModeleRepository taskModeleRepo;

	@Override
	public TacheModeleDTO ajoutTaskModele(TacheModeleDTO taskModeleDTO) {
		TacheModeleEntity taskModeleEntity = ModelMapperConverter.converToEntity(taskModeleDTO, TacheModeleEntity.class);

		return ModelMapperConverter.converToDTO(taskModeleRepo.save(taskModeleEntity), TacheModeleDTO.class);
	}

	@Override
	public TacheModeleDTO findById(Long id) {
		return ModelMapperConverter.converToDTO(taskModeleRepo.findById(id).orElse(null), TacheModeleDTO.class);
	}

	@Override
	public List<TacheModeleDTO> findAll() {
		return ModelMapperConverter.convertAllToDTO(taskModeleRepo.findAll(), TacheModeleDTO.class);
	}

	@Override
	public void deleteTaskModele(Long id) {
		taskModeleRepo.deleteById(id);

	}

	@Override
	public TacheModeleDTO findTaskModeleByNom(String nom) {
		return ModelMapperConverter.converToDTO(taskModeleRepo.findTaskModeleByNom(nom), TacheModeleDTO.class);
	}

}
