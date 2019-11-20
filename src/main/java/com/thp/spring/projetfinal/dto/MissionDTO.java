package com.thp.spring.projetfinal.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thp.spring.projetfinal.util.Statut;

public class MissionDTO extends MyDTO {

	private Long id;
	private String description;
	private Date dateDebut;
	private Date dateFin;
	@JsonIgnoreProperties({ "mission" })
	private UtilisateurDTO collaborateur;
	private ModeleDTO model;
	private Set<TacheMissionDTO> tachesMissions = new HashSet<>();
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

	public UtilisateurDTO getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(UtilisateurDTO collaborateur) {
		this.collaborateur = collaborateur;
	}

	public ModeleDTO getModel() {
		return model;
	}

	public void setModel(ModeleDTO model) {
		this.model = model;
	}

	public Set<TacheMissionDTO> getTachesMissions() {
		return tachesMissions;
	}

	public void setTachesMissions(Set<TacheMissionDTO> tachesMissions) {
		this.tachesMissions = tachesMissions;
	}

	public Statut getStatus() {
		return status;
	}

	public void setStatus(Statut status) {
		this.status = status;
	}

	public MissionDTO(Long id, String description, Date dateDebut, Date dateFin, UtilisateurDTO collaborateur,
			ModeleDTO model, Set<TacheMissionDTO> tachesMissions, Statut status) {
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

	public MissionDTO(String description, Date dateDebut, Date dateFin, UtilisateurDTO collaborateur, ModeleDTO model,
			Set<TacheMissionDTO> tachesMissions, Statut status) {
		super();
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.collaborateur = collaborateur;
		this.model = model;
		this.tachesMissions = tachesMissions;
		this.status = status;
	}

	public MissionDTO() {
		super();
	}

	public MissionDTO(String description, Set<TacheMissionDTO> tachesMissions) {
		super();
		this.description = description;
		this.tachesMissions = tachesMissions;
	}

	public MissionDTO(Long id, String description, Set<TacheMissionDTO> tachesMissions) {
		super();
		this.id = id;
		this.description = description;
		this.tachesMissions = tachesMissions;
	}

	@Override
	public String toString() {
		return "MissionEntity [id=" + id + ", description=" + description + ", dateDebut=" + dateDebut + ", dateFin="
				+ dateFin + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((collaborateur == null) ? 0 : collaborateur.hashCode());
		result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tachesMissions == null) ? 0 : tachesMissions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MissionDTO other = (MissionDTO) obj;
		if (collaborateur == null) {
			if (other.collaborateur != null)
				return false;
		} else if (!collaborateur.equals(other.collaborateur))
			return false;
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (status != other.status)
			return false;
		if (tachesMissions == null) {
			if (other.tachesMissions != null)
				return false;
		} else if (!tachesMissions.equals(other.tachesMissions))
			return false;
		return true;
	}

}
