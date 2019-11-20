package com.thp.spring.projetfinal.dto;

import com.thp.spring.projetfinal.util.Libelle;
public class RoleDTO extends MyDTO {

	private Long id;
	private Libelle libelle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Libelle getLibelle() {
		return libelle;
	}

	public void setLibelle(Libelle libelle) {
		this.libelle = libelle;
	}

	public RoleDTO(Long id, Libelle libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	public RoleDTO(Long id) {
		super();
		this.id = id;
	}

	public RoleDTO(Libelle libelle) {
		super();
		this.libelle = libelle;
	}

	public RoleDTO() {
		super();
	}

	@Override
	public String toString() {
		return "RoleDTO [id=" + id + ", libelle=" + libelle + "]";
	}

}
