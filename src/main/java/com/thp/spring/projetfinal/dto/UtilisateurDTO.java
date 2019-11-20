package com.thp.spring.projetfinal.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thp.spring.projetfinal.entities.MissionEntity;

public class UtilisateurDTO extends MyDTO {

	private Long id;
	private String pseudo;
	private String motDePasse;
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	private String mail;
	private String tel;
	private UtilisateurDTO manager;
	@JsonBackReference

	private List<UtilisateurDTO> collaborateurs;
	@JsonIgnoreProperties({ "collaborateur" })
	private List<MissionEntity> mission;

	private RoleDTO role;

	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public UtilisateurDTO getManager() {
		return manager;
	}

	public void setManager(UtilisateurDTO manager) {
		this.manager = manager;
	}

	public List<UtilisateurDTO> getCollaborateurs() {
		return collaborateurs;
	}

	public void setCollaborateurs(List<UtilisateurDTO> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

	public List<MissionEntity> getMission() {
		return mission;
	}

	public void setMission(List<MissionEntity> mission) {
		this.mission = mission;
	}

	public RoleDTO getRole() {
		return role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}

	public UtilisateurDTO(Long id, String pseudo, String motDePasse, String nom, String prenom, String adresse,
			String codePostal, String ville, String mail, String tel, UtilisateurDTO manager,
			List<UtilisateurDTO> collaborateurs, List<MissionEntity> mission, RoleDTO role) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.mail = mail;
		this.tel = tel;
		this.manager = manager;
		this.collaborateurs = collaborateurs;
		this.mission = mission;
		this.role = role;
	}


	public UtilisateurDTO(String pseudo, String motDePasse, String nom, String prenom, String adresse,
			String codePostal, String ville, String mail, String tel, UtilisateurDTO manager,
			List<UtilisateurDTO> collaborateurs, List<MissionEntity> mission, RoleDTO role) {
		super();
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.mail = mail;
		this.tel = tel;
		this.manager = manager;
		this.collaborateurs = collaborateurs;
		this.mission = mission;
		this.role = role;
	}

	public UtilisateurDTO() {
		super();
	}



	
	

	public UtilisateurDTO(Long id, String pseudo, String motDePasse, String nom) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.nom = nom;
	}



	public UtilisateurDTO(String pseudo, String motDePasse, String nom) {
		super();
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "UtilisateurDTO [id=" + id + ", pseudo=" + pseudo + ", motDePasse=" + motDePasse + ", nom=" + nom
				+ ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville
				+ ", mail=" + mail + ", tel=" + tel + ", manager=" + manager 
				+ ", mission=" + mission + ", role=" + role + "]";
	}

}
