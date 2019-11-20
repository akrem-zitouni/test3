package com.thp.spring.projetfinal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thp.spring.projetfinal.dto.MailDTO;
import com.thp.spring.projetfinal.dto.TacheMissionDTO;
import com.thp.spring.projetfinal.dto.UtilisateurDTO;
import com.thp.spring.projetfinal.service.EmailService;
import com.thp.spring.projetfinal.service.MissionService;
import com.thp.spring.projetfinal.service.TacheMissionService;
import com.thp.spring.projetfinal.service.UtilisateurService;
import com.thp.spring.projetfinal.util.Priorite;
import com.thp.spring.projetfinal.util.Statut;

@RestController
@CrossOrigin("*")
public class TacheMissionController {

	@Autowired
	TacheMissionService tacheMissionService;
	@Autowired
	EmailService emailService;
	@Autowired
	MissionService missionService;
	@Autowired
	UtilisateurService utilisateurService;

	@GetMapping(value = "/taches")
	public List<TacheMissionDTO> findAll() {
		return tacheMissionService.findAll();
	}

	@PutMapping(value = "/taches/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public TacheMissionDTO updateTask(@RequestBody TacheMissionDTO taskToUpdate) {
		return tacheMissionService.addTask(taskToUpdate);
	}

	@GetMapping(value = "/taches/{idUser}")
	public List<TacheMissionDTO> findMissionByUtilisateur(@PathVariable Long idUser) {
		return tacheMissionService.getTacheMissionByUtilisateurId(idUser);

	}

	@GetMapping(value = "/tachesp/{priorite}")
	public List<TacheMissionDTO> findMissionByUserAndPriorite(@PathVariable Long idUser) {

		return tacheMissionService.getTacheMissionByUtilisateurId(idUser);

	}

	@GetMapping(value = "/tachesCollaborateur/{idUser}")

	public List<TacheMissionDTO> getTacheCollaborateur(@PathVariable Long idUser) {
		List<TacheMissionDTO> tacheCollaborateur = new ArrayList<TacheMissionDTO>();
		List<TacheMissionDTO> tacheCollaborateurById = tacheMissionService.getTacheMissionByUtilisateurId(idUser);
		for (TacheMissionDTO tacheDTO : tacheCollaborateurById) {
			if (tacheDTO.getStatus() == Statut.DOING && tacheDTO.getPriorite() == Priorite.p0) {
				tacheCollaborateur.add(tacheDTO);
			}
		}
		
		return tacheCollaborateur;
	}
	
	@GetMapping(value = "/tachesCollaborateurPriorité/{idUser}")

	public List<TacheMissionDTO> getTacheCollaborateurPriorité(@PathVariable Long idUser) {
		List<TacheMissionDTO> tacheCollaborateur = new ArrayList<TacheMissionDTO>();
		List<TacheMissionDTO> tacheCollaborateurById = tacheMissionService.getTacheMissionByUtilisateurId(idUser);
		for (TacheMissionDTO tacheDTO : tacheCollaborateurById) {
			if (tacheDTO.getPriorite() == Priorite.p0) {
				tacheCollaborateur.add(tacheDTO);
			}
		}
	
		return tacheCollaborateur;
	}

	/* Si le Manager a une seule mission */
	@GetMapping(value = "/mailManager/{pseudo}")
	public void evoyerEmail(@PathVariable String pseudo) {
		MailDTO mMessage = new MailDTO();
		UtilisateurDTO utilisateurDTO = utilisateurService.findByPseudo(pseudo);
		Long idManager = utilisateurDTO.getManager().getId();
			String[] s = new String[] { utilisateurService.findById(idManager).getMail() };

				
				mMessage.setTo(s);
				mMessage.setSubject("test manager");
				mMessage.setText("Bonjour " + utilisateurService.findById(idManager).getNom() + " "
						+ utilisateurService.findById(idManager).getPrenom() 
						+ " de la mission " + missionService.findByCollaborateurManagerId(idManager).getDescription()
						+ " sont soumises avec succés par le collaborateur "
						+ missionService.findByCollaborateurManagerId(idManager).getCollaborateur().getPrenom() + " "
						+ missionService.findByCollaborateurManagerId(idManager).getCollaborateur().getNom() + " "
						+ "pour plus d'informations  veillez consulter le site");
				emailService.sendEmail(mMessage);
			

			
			
		

	}



}
