package com.example.demo.dao;

import java.util.*;

import com.example.demo.entities.*;


public class Singleton {
	
	static public Singleton  Instance ;
	public int idUser;
	public int idQuestionnaire;
	
	
	public List<Reponse> Reponses;  
	
	 public List<Reponse> getReponses() {
		return Reponses;
	}

	public void setReponses(List<Reponse> reponses) {
		Reponses = reponses;
	}

	
	
	
	
	public int getIdUser() {
		 
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdQuestionnaire() {
		return idQuestionnaire;
	}

	public void setIdQuestionnaire(int idQuestionnaire) {
		this.idQuestionnaire = idQuestionnaire;
	}

	public User user;
	 public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) 
	{
		this.questionnaire = questionnaire;
	}

	public Questionnaire questionnaire;
	public Questions questions;
	public Questions getQuestions() {
		return questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public static Singleton getInstance() {
		
		if(Instance==null)
		{
			Instance=new Singleton();
		}
		return Instance;
	}

	
	
	

}
