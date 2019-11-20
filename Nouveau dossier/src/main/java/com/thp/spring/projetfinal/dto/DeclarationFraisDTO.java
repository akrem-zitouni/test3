package com.thp.spring.projetfinal.dto;

import java.io.File;
import java.util.Date;

public class DeclarationFraisDTO extends MyDTO{

	

	private Long id;
	
	private String description;

	private Date dateDeclaration;

	private File fichier;
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
	public Date getDateDeclaration() {
		return dateDeclaration;
	}
	public void setDateDeclaration(Date dateDeclaration) {
		this.dateDeclaration = dateDeclaration;
	}
	public File getFichier() {
		return fichier;
	}
	public void setFichier(File fichier) {
		this.fichier = fichier;
	}
	
	public DeclarationFraisDTO(Long id, String description, Date dateDeclaration, File fichier) {
		super();
		this.id = id;
		this.description = description;
		this.dateDeclaration = dateDeclaration;
		this.fichier = fichier;
	}
	public DeclarationFraisDTO(String description, Date dateDeclaration, File fichier) {
		super();
		this.description = description;
		this.dateDeclaration = dateDeclaration;
		this.fichier = fichier;
	}
	public DeclarationFraisDTO() {
		super();
	
	}
	@Override
	public String toString() {
		return "DeclarationFraisDTO [id=" + id + ", description=" + description + ", dateDeclaration=" + dateDeclaration
				+ ", fichier=" + fichier + "]";
	}


	
	
}
