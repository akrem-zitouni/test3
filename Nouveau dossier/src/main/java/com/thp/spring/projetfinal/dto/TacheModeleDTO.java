package com.thp.spring.projetfinal.dto;

import java.util.ArrayList;
import java.util.Date;

import javax.mail.Multipart;

import com.thp.spring.projetfinal.util.Categorie;
import com.thp.spring.projetfinal.util.Priorite;
import com.thp.spring.projetfinal.util.Statut;
import com.thp.spring.projetfinal.util.Validite;
public class TacheModeleDTO extends MyDTO {

	private Long id;
	private String nom;
	private String dateEcheance;
	private ArrayList<Multipart> fichiers;
	private Categorie categorie;
	private RoleDTO role;
	private Priorite priorite = Priorite.p0;
	private Statut status = Statut.TODO;


	private Validite validite;
	private Date dateValidite;
	private String commentaire;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDateEcheance() {
		return dateEcheance;
	}
	public void setDateEcheance(String dateEcheance) {
		this.dateEcheance = dateEcheance;
	}
	public ArrayList<Multipart> getFichiers() {
		return fichiers;
	}
	public void setFichiers(ArrayList<Multipart> fichiers) {
		this.fichiers = fichiers;
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
	public Validite getValidite() {
		return validite;
	}
	public void setValidite(Validite validite) {
		this.validite = validite;
	}
	public Date getDateValidite() {
		return dateValidite;
	}
	public void setDateValidite(Date dateValidite) {
		this.dateValidite = dateValidite;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public TacheModeleDTO(Long id, String nom, String dateEcheance, ArrayList<Multipart> fichiers, Categorie categorie,
			RoleDTO role, Priorite priorite, Statut status, Validite validite, Date dateValidite, String commentaire) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateEcheance = dateEcheance;
		this.fichiers = fichiers;
		this.categorie = categorie;
		this.role = role;
		this.priorite = priorite;
		this.status = status;
		this.validite = validite;
		this.dateValidite = dateValidite;
		this.commentaire = commentaire;
	}
	public TacheModeleDTO(String nom, String dateEcheance, ArrayList<Multipart> fichiers, Categorie categorie,
			RoleDTO role, Priorite priorite, Statut status, Validite validite, Date dateValidite, String commentaire) {
		super();
		this.nom = nom;
		this.dateEcheance = dateEcheance;
		this.fichiers = fichiers;
		this.categorie = categorie;
		this.role = role;
		this.priorite = priorite;
		this.status = status;
		this.validite = validite;
		this.dateValidite = dateValidite;
		this.commentaire = commentaire;
	}
	@Override
	public String toString() {
		return "TacheModeleDTO [id=" + id + ", nom=" + nom + ", dateEcheance=" + dateEcheance + ", fichiers=" + fichiers
				+ ", categorie=" + categorie + ", role=" + role + ", priorite=" + priorite + ", status=" + status
				+ ", validite=" + validite + ", dateValidite=" + dateValidite + ", commentaire=" + commentaire + "]";
	}
	public TacheModeleDTO() {
		super();
	
	}
	public TacheModeleDTO(String nom, Categorie categorie) {
		super();
		this.nom = nom;
		this.categorie = categorie;
	}
	
	
	

}
