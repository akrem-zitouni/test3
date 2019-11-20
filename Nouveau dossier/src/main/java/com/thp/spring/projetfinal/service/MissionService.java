package com.thp.spring.projetfinal.service;

import java.util.List;

import com.thp.spring.projetfinal.dto.MissionDTO;
import com.thp.spring.projetfinal.entities.MissionEntity;

public interface MissionService {

	MissionDTO addMission(MissionDTO missionDTO);

	MissionDTO findById(Long id);

	List<MissionDTO> findAll();

	void deleteMission(Long id);

	MissionDTO findByDescription(String description);

	MissionDTO findByUtilisateur(Long idUtilisateur);

	MissionDTO findByCollaborateurManagerId(Long idManager);

	MissionEntity annulerMission(Long id);


}
