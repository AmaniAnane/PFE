package com.example.demo.web;

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
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Questions;
import com.example.demo.entities.Type;
@Controller
public class QuestionsControlleur {

@Autowired
private QuestionsRespository  questionsRespository;

@Autowired
private TypeRespository TypeRespository;

@Autowired

private CategorieRespository CategorieRespository;


	 @RequestMapping(value= {"Questions/add"} ,  method = RequestMethod.GET)
	 public String addQuestions(Model model) {
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
			questionsRespository.save(q);
			
			return "redirect:/Questions/lister";
		 
		 }
		 
		 @RequestMapping("/Questions/lister")
		 public String listQuestions(Model model)
		 {
			 model.addAttribute("Questions", questionsRespository.findAll());
			 return "Questions";
		 }
		 
		
		 @RequestMapping("Questions/update")
		 public String modifQuestions(Model model,int num) {
			 Questions q=questionsRespository.findById(num).get();
			 model.addAttribute("Questions",q);
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
