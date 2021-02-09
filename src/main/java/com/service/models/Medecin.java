package com.service.models;

public class Medecin {
	private long id;
	private String nom;
	private String prenom;
	private String cinMedecin;
	private String specialite;
	
	private String nomServiceDep;
	
	private Long idCompte;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getCinMedecin() {
		return cinMedecin;
	}

	public void setCinMedecin(String cinMedecin) {
		this.cinMedecin = cinMedecin;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getNomServiceDep() {
		return nomServiceDep;
	}

	public void setNomServiceDep(String nomServiceDep) {
		this.nomServiceDep = nomServiceDep;
	}

	public Long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	public Medecin(long id, String nom, String prenom, String cinMedecin, String specialite, String nomServiceDep,
			Long idCompte) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cinMedecin = cinMedecin;
		this.specialite = specialite;
		this.nomServiceDep = nomServiceDep;
		this.idCompte = idCompte;
	}

	public Medecin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
