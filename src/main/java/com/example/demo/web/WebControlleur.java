package com.example.demo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.criteria.From;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import com.example.demo.dao.CategorieRespository;
import com.example.demo.dao.ChoixRespositor;
import com.example.demo.dao.FonctionRespository;
import com.example.demo.dao.QuestionnaireRespository;
import com.example.demo.dao.UserRespository;

import com.example.demo.dao.TypeRespository;
import com.example.demo.dao.QuestionsRespository;
import com.example.demo.dao.ReponseRespositor;
import com.example.demo.dao.Singleton;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Choixreponse;
import com.example.demo.entities.Fonction;
import com.example.demo.entities.Questionnaire;
import com.example.demo.entities.User;



import com.example.demo.entities.Type;
import com.example.demo.entities.Questions;
import com.example.demo.entities.Reponse;


@Controller
public class WebControlleur {

@Autowired
	private ChoixRespositor choixRespositor;
	
	

@Autowired
private UserRespository UserRespository;

@Autowired
private QuestionsRespository  questionsRespository;
@Autowired
private QuestionnaireRespository QuestionnaireRespository;
@Autowired 
private ReponseRespositor ReponseRespositor;


@RequestMapping(value = { "/deconnecter" }, method = RequestMethod.GET)
public String deconnecter(Model model) {
	
 
	 return "login";
	 }

	 

	 
		 
		 //Reponse
		 
	/*
		 @RequestMapping("Choixreponse/add")
		 public String crationChoixReponce(Model model) {
			 model.addAttribute("Choixreponse",new Choixreponse() );
			 
			 return "crationChoixReponce";
			 
			 }
			 

		 @RequestMapping(value="/Choixreponse/save", method=RequestMethod.POST)
		 public String saveReponsee(@Valid @ModelAttribute Choixreponse R, BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
			 return "crationChoixReponce";
			 }
			choixRespositor.save(R);
			
			return "redirect:/Choixreponse/add";
		 
		 }
		*/
		 
		 
		
			 
			 
			
					 
			
				 

				 
				 
				 
				 
				 
				 
				 //QuestionnaireQuestions
				 
		
	
				 
				 
				 
		//UserQuestionnaire
				 

				    
				    
				    
					

					// @RequestMapping("/result1/{id}")
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
}
			
				 
		 
				
				 
				 

