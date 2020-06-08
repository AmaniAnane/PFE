package com.example.demo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Fonction implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_fonction;

	public Fonction(int id_fonction, String libelle) {
		super();
		this.id_fonction = id_fonction;
		this.libelle = libelle;
	}




	public Fonction() {
		super();
		// TODO Auto-generated constructor stub
	}




	private String libelle;

	public int getId_fonction() {
		return id_fonction;
	}
	public void setId_fonction(int id_fonction) {
		this.id_fonction = id_fonction;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return  libelle ;
	}
	
	
	

@OneToMany(mappedBy="u")
private Set<User>User =new 	HashSet<User>();
	
}
