package com.microservice.contacts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Address {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@JsonProperty("id_address") 
    private Long id_address; 
 
	@Column(name = "Nom_rue", length = 64) 
    @JsonProperty("nom_rue") 
    private String nom_rue; 
 
	@Column(name = "Numero_rue", length = 64) 
	@JsonProperty("numero_rue") 
    private String numero_rue; 
 
	@Column(name = "Numero_zone", length = 64) 
	@JsonProperty("numero_zone") 
    private String numero_zone;

	public Address() {
		super();
	}

	public Long getId_address() {
		return id_address;
	}

	public void setId_address(Long id_address) {
		this.id_address = id_address;
	}

	public String getNom_rue() {
		return nom_rue;
	}

	public void setNom_rue(String nom_rue) {
		this.nom_rue = nom_rue;
	}

	public String getNumero_rue() {
		return numero_rue;
	}

	public void setNumero_rue(String numero_rue) {
		this.numero_rue = numero_rue;
	}

	public String getNumero_zone() {
		return numero_zone;
	}

	public void setNumero_zone(String numero_zone) {
		this.numero_zone = numero_zone;
	}

	public Address(String nom_rue, String numero_rue, String numero_zone) {
		super();
		this.nom_rue = nom_rue;
		this.numero_rue = numero_rue;
		this.numero_zone = numero_zone;
	}
	
}
