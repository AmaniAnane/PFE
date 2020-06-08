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
public class Type implements Serializable{
	
		public Type() {
		super();
		// TODO Auto-generated constructor stub
	}




		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		    public int id_type ;
		    public String nom_type;
			
		  
			
			
			public int getId_type() {
				return id_type;
			}




			public void setId_type(int id_type) {
				this.id_type = id_type;
			}




			public String getNom_type() {
				return nom_type;
			}




			public void setNom_type(String nom_type) {
				this.nom_type = nom_type;
			}




			public Set<Questions> getQuestions() {
				return Questions;
			}




			public void setQuestions(Set<Questions> questions) {
				Questions = questions;
			}




			@Override
			public String toString() {
				return  nom_type ;
			}
		    
			
		    

@OneToMany(mappedBy="t")
private Set<Questions>Questions =new 	HashSet<Questions>();
		    
		   

}
