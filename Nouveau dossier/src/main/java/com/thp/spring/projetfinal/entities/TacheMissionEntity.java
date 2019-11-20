package com.thp.spring.projetfinal.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thp.spring.projetfinal.util.Categorie;

import com.thp.spring.projetfinal.util.Priorite;
import com.thp.spring.projetfinal.util.Statut;

@Entity
@Table(name = "tacheMission")
public class TacheMissionEntity extends MyEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4998385631960551892L;
	@Id
	@Column(name = "id_tachesmission")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "dateAffectation")
	private Date dateAffectation;
	@Column(name = "dateEcheance")
	private Date dateEcheance;
	@Column(name = "nom")
	private String nomTache;
	@Column(name = "description")
	private String description;

	@Column(name = "dateValidation")
	private Date dateValidation;
	@Column(name = "commentaire")
	private String commentaire;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "utilisateur_id")
	private UtilisateurEntity utilisateur;
	@Column(name = "categorie")
	@Enumerated(EnumType.STRING)
	private Categorie categorie;
	@Column(name = "status", columnDefinition = "varchar(32) default 'TODO'")
	@Enumerated(EnumType.STRING)
	private Statut status = Statut.TODO;
	@Column(name = "priorite", columnDefinition = "varchar(32) default 'p0'")
	@Enumerated(EnumType.STRING)
	private Priorite priorite = Priorite.p0;

	@ManyToOne
	private RoleEntity role;
	@OneToOne
	@JoinColumn(name = "file_id")
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

	public String getNomTache() {
		return nomTache;
	}

	public void setNomTache(String nomTache) {
		this.nomTache = nomTache;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UtilisateurEntity getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UtilisateurEntity utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Statut getStatus() {
		return status;
	}

	public void setStatus(Statut status) {
		this.status = status;
	}

	public Priorite getPriorite() {
		return priorite;
	}

	public void setPriorite(Priorite priorite) {
		this.priorite = priorite;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public DBFile getDbFile() {
		return dbFile;
	}

	public void setDbFile(DBFile dbFile) {
		this.dbFile = dbFile;
	}

	public TacheMissionEntity(Date dateAffectation, Date dateEcheance, String nomTache, String description,
			UtilisateurEntity utilisateur, Categorie categorie, Statut status, Priorite priorite, RoleEntity role,
			DBFile dbFile) {
		super();
		this.dateAffectation = dateAffectation;
		this.dateEcheance = dateEcheance;
		this.nomTache = nomTache;
		this.description = description;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
		this.status = status;
		this.priorite = priorite;
		this.role = role;
		this.dbFile = dbFile;
	}

	public Date getDateValidation() {
		return dateValidation;
	}

	public void setDateValidation(Date dateValidation) {
		this.dateValidation = dateValidation;
	}

	public TacheMissionEntity(Date dateAffectation, Date dateEcheance, String nomTache, String description,
			UtilisateurEntity utilisateur, Categorie categorie, Statut status, Priorite priorite, DBFile dbFile) {
		super();
		this.dateAffectation = dateAffectation;
		this.dateEcheance = dateEcheance;
		this.nomTache = nomTache;
		this.description = description;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
		this.status = status;
		this.priorite = priorite;
		this.dbFile = dbFile;

	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;

	}

	@Override
	public String toString() {
		return "TacheMissionEntity [dateAffectation=" + dateAffectation + ", dateEcheance=" + dateEcheance
				+ ", nomTache=" + nomTache + ", description=" + description + ", dateValidation=" + dateValidation
				+ ", commentaire=" + commentaire + ", utilisateur=" + utilisateur + ", categorie=" + categorie
				+ ", status=" + status + ", priorite=" + priorite + ", role=" + role + ", dbFile=" + dbFile + "]";
	}

	public TacheMissionEntity() {
		super();

	}

	public TacheMissionEntity(Date dateAffectation, Date dateEcheance, String nomTache, String description,
			Date dateValidation, String commentaire, UtilisateurEntity utilisateur, Categorie categorie, Statut status,
			Priorite priorite, RoleEntity role, DBFile dbFile) {
		super();
		this.dateAffectation = dateAffectation;
		this.dateEcheance = dateEcheance;
		this.nomTache = nomTache;
		this.description = description;
		this.dateValidation = dateValidation;
		this.commentaire = commentaire;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
		this.status = status;
		this.priorite = priorite;
		this.role = role;
		this.dbFile = dbFile;
	}

}
