package com.microservice.contacts.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Personnes implements Serializable{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@JsonProperty("id") 
    private Long id; 
 
	@Column(name = "Nom", length = 64) 
    @JsonProperty("nom") 
    private String nom; 
 
	@Column(name = "Prenom", length = 64) 
	@JsonProperty("prenom") 
    private String prenom; 
 
	@Column(name = "Roles", length = 64) 
	@JsonProperty("roles") 
    private String roles;

	public Personnes() {}
	
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Personnes(String nom, String prenom, String roles) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.roles = roles;
	}
	
	


 
}

