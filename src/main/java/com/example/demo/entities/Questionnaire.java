package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;




@Entity
public class Questionnaire implements Serializable{
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    public int id_questionnaire ;
	private Date date;
	private String titre;
  
	
	@Override
	public String toString() {
		return "Questionnaire " + id_questionnaire ;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Set<User> getUser() {
		return User;
	}
	public void setUser(Set<User> user) {
		User = user;
	}
	
	
	public int getId_questionnaire() {
		return id_questionnaire;
	}
	public void setId_questionnaire(int id_questionnaire) {
		this.id_questionnaire = id_questionnaire;
	}
	public Date  getDate() {
		return date;
	}
	public void setDate(Date  date) {
		this.date = date;
	}
	
	
	@ManyToMany(mappedBy="Questionnaires")

	private Set <User>User;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="affictation_Questions")
	
	private Set<Questions> Questionss = new HashSet<Questions>(0);


	public Set<Questions> getQuestionss() {
		return Questionss;
	}
	public void setQuestionss(Set<Questions> questionss) {
		Questionss = questionss;
	}
	
	public boolean hasQuestions(Questions questions) {
		for (Questions QuestionnaireQuestions: getQuestionss()) {
			if (QuestionnaireQuestions.getId_question() == questions.getId_question()) {
				return true;
			}
		}
		return false;
	} 


}
