package com.example.demo.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import net.codejava.Role;

//import net.codejava.Role;

//import net.javaguides.springbootsecurity.entities.Role;

@Entity
@Table(name = "users")
public class User {






	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private int id_User;

	private String nom_User;

	private String prenom_User;
	private Boolean enabled;
    @Column(unique = true)
	private String email_User;

	private int telephon;

    @Column(unique = true)
private String username;
	private String password;
	
	
	
	
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	private Set<Role> roles = new HashSet<>(); 

	
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	public int getId_User() {
		return id_User;
	}

	public void setId_User(int id_User) {
		this.id_User = id_User;
	}

	public String getNom_User() {
		return nom_User;
	}

	public void setNom_User(String nom_User) {
		this.nom_User = nom_User;
	}

	public String getPrenom_User() {
		return prenom_User;
	}

	public void setPrenom_User(String prenom_User) {
		this.prenom_User = prenom_User;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail_User() {
		return email_User;
	}

	public void setEmail_User(String email_User) {
		this.email_User = email_User;
	}

	public int getTelephon() {
		return telephon;
	}

	public void setTelephon(int telephon) {
		this.telephon = telephon;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name = "affictation_user")
	private Set<Questionnaire> Questionnaires = new HashSet<Questionnaire>(0);

	@ManyToOne
	@JoinColumn(name = "id_fonction")
	private Fonction u;

	public Set<Questionnaire> getQuestionnaires() {
		return Questionnaires;
	}

	public void setQuestionnaires(Set<Questionnaire> questionnaires) {
		Questionnaires = questionnaires;
	}

	public Fonction getU() {
		return u;
	}

	public void setU(Fonction u) {
		this.u = u;
	}
	public boolean hasQuestionnaire(Questionnaire questionnaire) {
		for (Questionnaire UserQuestionnaire : getQuestionnaires()) {
			if (UserQuestionnaire.getId_questionnaire() == questionnaire.getId_questionnaire()) {
				return true;
			}
		}
		return false;
	}
	@OneToMany(mappedBy = "User")
	private Set<Reponse> Reponse = new HashSet<Reponse>();



	public Set<Reponse> getReponse() {
		return Reponse;
	}

	public void setReponse(Set<Reponse> reponse) {
		Reponse = reponse;
	}

}
