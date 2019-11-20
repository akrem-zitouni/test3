package com.thp.spring.projetfinal.entities;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.thp.spring.projetfinal.util.Categorie;
import com.thp.spring.projetfinal.util.Priorite;
import com.thp.spring.projetfinal.util.Statut;
import com.thp.spring.projetfinal.util.Validite;

@Entity
@Table(name = "task")
public class TacheModeleEntity extends MyEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nom")
	private String nom;

	@Column(name = "dateEcheance")
	private String dateEcheance;

	@Column(name = "fichier")
	private File fichier;
	@Column(name = "categorie")
	@Enumerated(EnumType.STRING)
	private Categorie categorie;


	@ManyToOne
	private RoleEntity role;
	
	
	@Column(name = "status" ,columnDefinition = "varchar(32) default 'TODO'")
	@Enumerated(EnumType.STRING)
	private Statut status = Statut.TODO;
	@Column(name = "priorite" ,columnDefinition = "varchar(32) default 'p0'")
	@Enumerated(EnumType.STRING)
	private Priorite priorite = Priorite.p0;
	
	@Column(name = "validite")
	@Enumerated(EnumType.STRING)
	private Validite validite;
	@Column(name = "dateValidite")
	private Date dateValidite;
	@Column(name = "commentaire")
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
	public File getFichier() {
		return fichier;
	}
	public void setFichier(File fichier) {
		this.fichier = fichier;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public RoleEntity getRole() {
		return role;
	}
	public void setRole(RoleEntity role) {
		this.role = role;
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
	public TacheModeleEntity(Long id, String nom, String dateEcheance, File fichier, Categorie categorie,
			RoleEntity role, Statut status, Priorite priorite, Validite validite, Date dateValidite,
			String commentaire) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateEcheance = dateEcheance;
		this.fichier = fichier;
		this.categorie = categorie;
		this.role = role;
		this.status = status;
		this.priorite = priorite;
		this.validite = validite;
		this.dateValidite = dateValidite;
		this.commentaire = commentaire;
	}
	public TacheModeleEntity(String nom, String dateEcheance, File fichier, Categorie categorie, RoleEntity role,
			Statut status, Priorite priorite, Validite validite, Date dateValidite, String commentaire) {
		super();
		this.nom = nom;
		this.dateEcheance = dateEcheance;
		this.fichier = fichier;
		this.categorie = categorie;
		this.role = role;
		this.status = status;
		this.priorite = priorite;
		this.validite = validite;
		this.dateValidite = dateValidite;
		this.commentaire = commentaire;
	}
	public TacheModeleEntity() {
		super();
	}
	@Override
	public String toString() {
		return "TacheModeleEntity [id=" + id + ", nom=" + nom + ", dateEcheance=" + dateEcheance + ", fichier="
				+ fichier + ", categorie=" + categorie + ", role=" + role + ", status=" + status + ", priorite="
				+ priorite + ", validite=" + validite + ", dateValidite=" + dateValidite + ", commentaire="
				+ commentaire + "]";
	}
	
	
}
