package com.example.demo.web;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.CategorieRespository;
import com.example.demo.dao.QuestionnaireRespository;
import com.example.demo.dao.QuestionsRespository;
import com.example.demo.dao.TypeRespository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Questions;
import com.example.demo.entities.Type;
import com.example.demo.entities.User;
@Controller
public class QuestionsControlleur {

@Autowired
private QuestionsRespository  questionsRespository;

@Autowired
private TypeRespository TypeRespository;

@Autowired

private CategorieRespository CategorieRespository;
@Autowired
private UserRepository UserRespository;

	 @RequestMapping(value= {"/Questions/add"} ,  method = RequestMethod.GET)
	 public String addQuestions(Model model ,Principal principal)
	 {
		 String name= principal.getName();
		 User user=UserRespository.getUserByUsername(name);
		 model.addAttribute("user",user);
		 
		 model.addAttribute("Questions",new Questions() );
		 
		 
		 ArrayList<Type> Type = (ArrayList<Type>) TypeRespository.findAll();
		  model.addAttribute("Type", Type);
		 
		  
		  ArrayList<Categorie> Categorie = (ArrayList<Categorie>) CategorieRespository.findAll();
		  model.addAttribute("Categorie", Categorie);
		 
		 return "addQuestions";
		 }
		 

		 @RequestMapping(value="Questions/save", method=RequestMethod.POST)
		 public String saveQuestions(@Valid @ModelAttribute Questions q, BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
			 return "addQuestions";
			 }
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    	   LocalDateTime now = LocalDateTime.now();  
	    	   String date =dtf.format(now);
	    	   q.setDate(date);
			questionsRespository.save(q);
			
			return "redirect:/Questions/lister";
		 
		 }
		 
		 @RequestMapping("/Questions/lister")
		 public String listQuestions(Model model ,Principal principal)
		 {
			 String name= principal.getName();
			 User user=UserRespository.getUserByUsername(name);
			 model.addAttribute("user",user);
			 model.addAttribute("Questions", questionsRespository.findAll());
			 return "Questions";
		 }
		 
		
		 @RequestMapping("Questions/update")
		 public String modifQuestions(Model model,int num,Principal principal)
		 {
			 String name= principal.getName();
			 User user=UserRespository.getUserByUsername(name);
			 model.addAttribute("user",user);
			 Questions q=questionsRespository.findById(num).get();
			 model.addAttribute("Questions",q);
			  ArrayList<Categorie> Categorie = (ArrayList<Categorie>) CategorieRespository.findAll();
			  model.addAttribute("Categorie", Categorie);
			 
			
			 return "modifQuestions";
		 }
		 @RequestMapping(value="/Questions/modifier",method=RequestMethod.POST)
		 public String updateQuestions(@Valid @ModelAttribute Questions q,BindingResult bindingResult) {
			 if(bindingResult.hasErrors()) {
				 return "modifQuestions";
			 }
			 questionsRespository.saveAndFlush(q);
			 return "redirect:/Questions/lister";
		 }
		 
		 @RequestMapping(value="/Questions/delete",method=RequestMethod.GET)
			public String deleteQuestions(Questions q, int num) {
			 questionsRespository.deleteById(num);
				
				return "redirect:/Questions/lister";
			}
	 

}
