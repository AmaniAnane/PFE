package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Reponse {
	public int getId_reponse() {
		return id_reponse;
	}


	public void setId_reponse(int id_reponse) {
		this.id_reponse = id_reponse;
	}


	public Set<Choixreponse> getChoixreponse() {
		return Choixreponse;
	}


	public Reponse(int id_reponse, Set<com.example.demo.entities.Choixreponse> choixreponse,
			com.example.demo.entities.User user, Questions questions, Questionnaire questionnaire) {
		super();
		this.id_reponse = id_reponse;
		Choixreponse = choixreponse;
		User = user;
		this.questions = questions;
		this.questionnaire = questionnaire;
	}


	public Reponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void setChoixreponse(Set<Choixreponse> choixreponse) {
		Choixreponse = choixreponse;
	}


	public User getUser() {
		return User;
	}


	public void setUser(User user) {
		User = user;
	}


	public Questions getQuestions() {
		return questions;
	}


	public void setQuestions(Questions questions) {
		this.questions = questions;
	}


	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}


	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_reponse ;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="reponse_choiser")
	
	private Set<Choixreponse> Choixreponse = new HashSet<Choixreponse>(0);

	
	
	@ManyToOne
	@JoinColumn(name="id_User")
    private User User ;
	
	@ManyToOne
	@JoinColumn(name="id_question")
    private Questions questions ;


	@ManyToOne
	@JoinColumn(name="id_questionnaire")
    private Questionnaire questionnaire ;
	
	

}
