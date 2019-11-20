package com.thp.spring.projetfinal.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "utilisateur")
public class UtilisateurEntity extends MyEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3834769352668673471L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "pseudo", unique = true, length = 500)
	private String pseudo;
	@Column(name = "mot_de_passe")
	private String motDePasse;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "cin")
	private String cin;
	@Column(name = "code_postal")
	private String codePostal;
	@Column(name = "ville")
	private String ville;
	@Column(name = "mail")
	private String mail;
	@Column(name = "tel")
	private String tel;

	@ManyToOne
	@JoinColumn(name = "manager_id")

	private UtilisateurEntity manager;


	@OneToMany(mappedBy = "collaborateur")
	@JsonIgnoreProperties({ "collaborateur" })
	private List<MissionEntity> mission;
	@JsonBackReference
	@OneToMany(mappedBy = "manager")
	private List<UtilisateurEntity> collaborateurs;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private RoleEntity role;

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

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
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

	public UtilisateurEntity getManager() {
		return manager;
	}

	public void setManager(UtilisateurEntity manager) {
		this.manager = manager;
	}

	public List<MissionEntity> getMission() {
		return mission;
	}

	public void setMission(List<MissionEntity> mission) {
		this.mission = mission;
	}

	public List<UtilisateurEntity> getCollaborateurs() {
		return collaborateurs;
	}

	public void setCollaborateurs(List<UtilisateurEntity> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UtilisateurEntity [id=" + id + ", pseudo=" + pseudo + ", motDePasse=" + motDePasse + ", nom=" + nom
				+ ", prenom=" + prenom + ", adresse=" + adresse + ", cin=" + cin + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", mail=" + mail + ", tel=" + tel + ", manager=" + manager + ", mission="
				+ mission + ", collaborateurs=" + collaborateurs + ", role=" + role + "]";
	}

	public UtilisateurEntity(Long id, String pseudo, String motDePasse, String nom, String prenom, String adresse,
			String cin, String codePostal, String ville, String mail, String tel, UtilisateurEntity manager,
			List<MissionEntity> mission, List<UtilisateurEntity> collaborateurs, RoleEntity role) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cin = cin;
		this.codePostal = codePostal;
		this.ville = ville;
		this.mail = mail;
		this.tel = tel;
		this.manager = manager;
		this.mission = mission;
		this.collaborateurs = collaborateurs;
		this.role = role;
	}

	public UtilisateurEntity(String pseudo, String motDePasse, String nom, String prenom, String adresse, String cin,
			String codePostal, String ville, String mail, String tel, UtilisateurEntity manager,
			List<MissionEntity> mission, List<UtilisateurEntity> collaborateurs, RoleEntity role) {
		super();
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cin = cin;
		this.codePostal = codePostal;
		this.ville = ville;
		this.mail = mail;
		this.tel = tel;
		this.manager = manager;
		this.mission = mission;
		this.collaborateurs = collaborateurs;
		this.role = role;
	}

	public UtilisateurEntity(String pseudo, String motDePasse) {
		super();
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
	}

	public UtilisateurEntity(String nom, String prenom, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	public UtilisateurEntity() {
		super();

	}

}
