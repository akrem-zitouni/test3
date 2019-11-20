package com.thp.spring.projetfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thp.spring.projetfinal.dto.UtilisateurDTO;

import com.thp.spring.projetfinal.model.UtilisateurDetailsService;
import com.thp.spring.projetfinal.service.RoleService;
import com.thp.spring.projetfinal.service.UtilisateurService;
import com.thp.spring.projetfinal.util.Libelle;

@RestController
@CrossOrigin("*")
public class UtilisateurController {

	@Autowired
	UtilisateurService utilisateurService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UtilisateurDetailsService utilisateurDetailsService;
	@Autowired
	RoleService roleService;

	@PostMapping(value = "/utilisateur")
	public UtilisateurDTO addUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
		

		utilisateurDTO.setMotDePasse(passwordEncoder.encode(utilisateurDTO.getMotDePasse()));
		utilisateurDTO.setRole(roleService.findRolebyLibelle(Libelle.COLLABORATEUR));
		return utilisateurService.addUtilisateur(utilisateurDTO);

	}

	@GetMapping(value = "/utilisateurs")
	public List<UtilisateurDTO> findAllUser() {
		return utilisateurService.findAll();

	}

	@GetMapping(value = "/utilisateur")
	public UtilisateurDTO getUser(@RequestParam Long id) {
		return utilisateurService.findById(id);
	}

	@GetMapping(value = "/parPseudo/{pseudo}")
	public UtilisateurDTO getUserByPseudo(@PathVariable String pseudo) {
		
		return utilisateurService.findByPseudo(pseudo);
	}

	@PutMapping(value = "/utilisateur")
	public UtilisateurDTO updateUser(@RequestBody UtilisateurDTO utilisateurDTO) {
		utilisateurDTO.setMotDePasse(passwordEncoder.encode(utilisateurDTO.getMotDePasse()));
		return utilisateurService.addUtilisateur(utilisateurDTO);
	}

	@DeleteMapping(value = "/utilisateur/{idUtilisateur}")
	public void deleteUser(@PathVariable Long idUtilisateur) {
		utilisateurService.deleteUtilisateur(idUtilisateur);
	}
	@GetMapping(value="/utilisateur/{idManager}")
	public List<UtilisateurDTO> getCollaborateurByManagerId(@PathVariable Long idManager){
		return utilisateurService.findByManagerId(idManager);
		
	}
	@GetMapping(value="/utilisateurRole/{idManager}")
	public List<UtilisateurDTO> getCollaborateurByRoleId(@PathVariable Long idManager){
		return utilisateurService.findByRoleId(idManager);
		
	}
	
	@GetMapping(value = "/collaborateursManager")
    public List<UtilisateurDTO> getCollaborateurOfManager(@RequestParam String managerPseudo){
        return utilisateurService.findCollaborateursOfManager(managerPseudo);
    }
	@GetMapping(value = "/collaborateursManagers")
    public List<UtilisateurDTO> getCollaborateursAndManagers(){
        return utilisateurService.findCollaborateursAndManagers();
    }
	@GetMapping(value = "/managers")
    public List<UtilisateurDTO> getManagers(){
        return utilisateurService.findManagers();
    }
}
