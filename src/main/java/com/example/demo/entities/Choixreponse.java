package com.example.demo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity

public class Choixreponse implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_choix ;
	private String choix ;
	private Integer bonne_reponse=0 ;

@Override
	public String toString() {
		return   "REPONSE ="+choix;
	}



public int getId_choix() {
		return id_choix;
	}









	public void setId_choix(int id_choix) {
		this.id_choix = id_choix;
	}

	public String getChoix() {
		return choix;
	}


	public void setChoix(String choix) {
		this.choix = choix;
	}


	public Integer getBonne_reponse() {
		return bonne_reponse;
	}



	public void setBonne_reponse(Integer bonne_reponse) {
		this.bonne_reponse = bonne_reponse;
	}







	

	@ManyToOne
	@JoinColumn(name="id_question")
    private Questions ch ;

	public Questions getCh() {
		return ch;
	}
	public int getIdQ() {
		return getCh().id_question;
	}


	public void setCh(Questions ch) {
		this.ch = ch;
	}


	@ManyToMany(mappedBy="Choixreponse")
	private Set<Reponse> Reponse;


	

		
}
