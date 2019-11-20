package com.thp.spring.projetfinal.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.thp.spring.projetfinal.util.Libelle;

@Entity
@Table(name = "role")
public class RoleEntity extends MyEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3366472711075202404L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "libelle")
	@Enumerated(EnumType.STRING)
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

	public RoleEntity(Long id, Libelle libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	public RoleEntity() {
		super();
	}

	public RoleEntity(Libelle libelle) {
		super();
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "RoleEntity [id=" + id + ", libelle=" + libelle + "]";
	}

}
