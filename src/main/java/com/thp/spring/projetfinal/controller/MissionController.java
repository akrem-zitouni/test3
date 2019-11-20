package com.thp.spring.projetfinal.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thp.spring.projetfinal.dto.MissionDTO;
import com.thp.spring.projetfinal.dto.TacheMissionDTO;
import com.thp.spring.projetfinal.dto.TacheModeleDTO;
import com.thp.spring.projetfinal.dto.UtilisateurDTO;
import com.thp.spring.projetfinal.entities.MissionEntity;
import com.thp.spring.projetfinal.service.MissionService;
import com.thp.spring.projetfinal.service.UtilisateurService;
import com.thp.spring.projetfinal.util.Priorite;
import com.thp.spring.projetfinal.util.Statut;

@RestController
@CrossOrigin("*")
public class MissionController {

	@Autowired
	MissionService missionService;
	@Autowired
	UtilisateurService utilisateurService;

	@PostMapping(value = "/mission")
	public MissionDTO addMission(@RequestBody MissionDTO missionDTO) {
		Set<TacheMissionDTO> tacheMissionDTOs = new HashSet<>();
		List<TacheModeleDTO> tacheModeleDTOs = missionDTO.getModel().getTaskModels();

		for (TacheModeleDTO tacheModeleDTO : tacheModeleDTOs) {
			TacheMissionDTO tacheMissionDTO = new TacheMissionDTO();
			tacheMissionDTO.setNomTache(tacheModeleDTO.getNom());

			tacheMissionDTO.setPriorite(tacheModeleDTO.getPriorite());
			tacheMissionDTO.setCategorie(tacheModeleDTO.getCategorie());
			tacheMissionDTO.setRole(tacheModeleDTO.getRole());

			switch (tacheModeleDTO.getRole().getLibelle()) {
			case COLLABORATEUR:
				tacheMissionDTO.setUtilisateur(missionDTO.getCollaborateur());
				break;
			case MANAGER:
				tacheMissionDTO.setUtilisateur(missionDTO.getCollaborateur().getManager());
				break;
			case BO:
				tacheMissionDTO.setUtilisateur(utilisateurService.findByPseudo("BO"));
				break;
			case BORH:
				tacheMissionDTO.setUtilisateur(utilisateurService.findByPseudo("BO"));
				break;
			default:
			}

			if (tacheModeleDTO.getPriorite() == Priorite.p1) {
				tacheMissionDTO.setDateAffectation(new Date());
				Date date = new Date();
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				c.add(Calendar.DATE, Integer.parseInt(tacheModeleDTO.getDateEcheance()));
				date = c.getTime();
				tacheMissionDTO.setDateEcheance(date);
			}
			if (tacheModeleDTO.getPriorite() == Priorite.p0) {
				tacheMissionDTO.setStatus(Statut.DOING);
			} else {
				tacheMissionDTO.setStatus(Statut.TODO);
			}
			tacheMissionDTOs.add(tacheMissionDTO);
		}
		missionDTO.setTachesMissions(tacheMissionDTOs);
		return missionService.addMission(missionDTO);
	}

	@GetMapping(value = "/mission/{id}")
	public MissionDTO getMisiionById(@PathVariable Long id) {
		return missionService.findById(id);
	}

	@GetMapping(value = "/mission/collab")
	public MissionDTO getMisiionByUtilisateur(@RequestParam Long id) {
		return missionService.findByUtilisateur(id);
	}

	@GetMapping(value = "/mission")
	public List<MissionDTO> findAllUser() {
		return missionService.findAll();

	}



	@DeleteMapping(value = "/mission/{idMission}")
	public void deleteMission(@PathVariable Long idMission) {
		missionService.deleteMission(idMission);
	}

	@PutMapping(value = "/mission")
	public MissionDTO updateMission(@RequestBody MissionDTO missionDTO) {
		MissionDTO missionB = missionService.findById(missionDTO.getId());
		missionDTO.setCollaborateur(missionB.getCollaborateur());
		missionDTO.setModel(missionB.getModel());
	
		return missionService.addMission(missionDTO);
	}

	@GetMapping(value = "/missionsCollaborateursManager")
	public List<MissionEntity> getMissionsCollaborateurOfManager(@RequestParam String managerPseudo) {
		List<MissionEntity> missionCollaborateurs = new ArrayList<>();
		List<UtilisateurDTO> collaborateursManager = utilisateurService.findCollaborateursOfManager(managerPseudo);
		for (UtilisateurDTO collaborateur : collaborateursManager) {
		
			missionCollaborateurs.addAll(collaborateur.getMission());
		}
		return missionCollaborateurs;
	}

	@PutMapping(value = "/annulermission/{id}")
	public MissionEntity annulerMissionByid(@PathVariable Long id) {
		return missionService.annulerMission(id);
	}

}
