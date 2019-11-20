package com.thp.spring.projetfinal.dto;

import java.util.Date;

import com.thp.spring.projetfinal.entities.DBFile;

import com.thp.spring.projetfinal.util.Categorie;
import com.thp.spring.projetfinal.util.Priorite;
import com.thp.spring.projetfinal.util.Statut;


public class TacheMissionDTO extends MyDTO {

	private Long id;
	private Date dateAffectation;
	private Date dateEcheance;
	private String description;

	private UtilisateurDTO utilisateur;
	private String nomTache;
	private Priorite priorite = Priorite.p0;
	private Statut status = Statut.TODO;
	private Categorie categorie;
	private RoleDTO role;

	private Date dateValidation;
	private String commentaire;
	

	private DBFile dbFile;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateAffectation() {
		return dateAffectation;
	}
	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}
	public Date getDateEcheance() {
		return dateEcheance;
	}
	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public UtilisateurDTO getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(UtilisateurDTO utilisateur) {
		this.utilisateur = utilisateur;
	}
	public String getNomTache() {
		return nomTache;
	}
	public void setNomTache(String nomTache) {
		this.nomTache = nomTache;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public RoleDTO getRole() {
		return role;
	}
	public void setRole(RoleDTO role) {
		this.role = role;
	}


	

	public Priorite getPriorite() {
		return priorite;
	}

	public void setPriorite(Priorite priorite) {
		this.priorite = priorite;
	}

	public Statut getStatus() {
		return status;
	}

	public void setStatus(Statut status) {
		this.status = status;
	}


	public Date getDateValidation() {
		return dateValidation;
	}

	public void setDateValidation(Date dateValidation) {
		this.dateValidation = dateValidation;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public DBFile getDbFile() {
		return dbFile;
	}
	public void setDbFile(DBFile dbFile) {
		this.dbFile = dbFile;
	}
	public TacheMissionDTO() {
		super();
	
	}
	public TacheMissionDTO(Long id, Date dateAffectation, Date dateEcheance, String description,
			UtilisateurDTO utilisateur, String nomTache, Priorite priorite, Statut status, Categorie categorie,
			RoleDTO role, Date dateValidation, String commentaire, DBFile dbFile) {
		super();
		this.id = id;
		this.dateAffectation = dateAffectation;
		this.dateEcheance = dateEcheance;
		this.description = description;
		this.utilisateur = utilisateur;
		this.nomTache = nomTache;
		this.priorite = priorite;
		this.status = status;
		this.categorie = categorie;
		this.role = role;
		this.dateValidation = dateValidation;
		this.commentaire = commentaire;
		this.dbFile = dbFile;
	}
	public TacheMissionDTO(Date dateAffectation, Date dateEcheance, String description, UtilisateurDTO utilisateur,
			String nomTache, Priorite priorite, Statut status, Categorie categorie, RoleDTO role, Date dateValidation,
			String commentaire, DBFile dbFile) {
		super();
		this.dateAffectation = dateAffectation;
		this.dateEcheance = dateEcheance;
		this.description = description;
		this.utilisateur = utilisateur;
		this.nomTache = nomTache;
		this.priorite = priorite;
		this.status = status;
		this.categorie = categorie;
		this.role = role;
		this.dateValidation = dateValidation;
		this.commentaire = commentaire;
		this.dbFile = dbFile;
	}
	public TacheMissionDTO(String nomTache, Categorie categorie) {
		super();
		this.nomTache = nomTache;
		this.categorie = categorie;
	}

	

	

	

	
	
}
