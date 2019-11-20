package com.thp.spring.projetfinal.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thp.spring.projetfinal.util.Statut;

@Entity
@Table(name = "mission")
public class MissionEntity extends MyEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3172107856099673686L;

	@Id
	@Column(name = "id_mission")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "description")
	private String description;
	@Column(name = "dateDebut")
	private Date dateDebut;
	@Column(name = "dateFin")
	private Date dateFin;
	@ManyToOne
	@JoinColumn(name = "collaborateur_id")
	@JsonIgnoreProperties({"mission"})
	private UtilisateurEntity collaborateur;
	@ManyToOne
	@JoinColumn(name = "model")
	private ModeleEntity model;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "mission_taches_mission", joinColumns = {
			@JoinColumn(name = "idMission", referencedColumnName = "id_mission") }, inverseJoinColumns = {
					@JoinColumn(name = "idTachemission", referencedColumnName = "id_tachesmission") })
	private Set<TacheMissionEntity> tachesMissions = new HashSet<>();
	@Column(name = "status" ,columnDefinition = "varchar(32) default 'TODO'")
	@Enumerated(EnumType.STRING)
	private Statut status = Statut.TODO;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public UtilisateurEntity getCollaborateur() {
		return collaborateur;
	}
	public void setCollaborateur(UtilisateurEntity collaborateur) {
		this.collaborateur = collaborateur;
	}
	public ModeleEntity getModel() {
		return model;
	}
	public void setModel(ModeleEntity model) {
		this.model = model;
	}
	public Set<TacheMissionEntity> getTachesMissions() {
		return tachesMissions;
	}
	public void setTachesMissions(Set<TacheMissionEntity> tachesMissions) {
		this.tachesMissions = tachesMissions;
	}
	public Statut getStatus() {
		return status;
	}
	public void setStatus(Statut status) {
		this.status = status;
	}
	public MissionEntity(Long id, String description, Date dateDebut, Date dateFin, UtilisateurEntity collaborateur,
			ModeleEntity model, Set<TacheMissionEntity> tachesMissions, Statut status) {
		super();
		this.id = id;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.collaborateur = collaborateur;
		this.model = model;
		this.tachesMissions = tachesMissions;
		this.status = status;
	}
	public MissionEntity(String description, Date dateDebut, Date dateFin, UtilisateurEntity collaborateur,
			ModeleEntity model, Set<TacheMissionEntity> tachesMissions, Statut status) {
		super();
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.collaborateur = collaborateur;
		this.model = model;
		this.tachesMissions = tachesMissions;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "MissionEntity [id=" + id + ", description=" + description + ", dateDebut=" + dateDebut + ", dateFin="
				+ dateFin +  ", status=" + status + "]";
	}
	public MissionEntity() {
		super();
	}

	
	
	
}
