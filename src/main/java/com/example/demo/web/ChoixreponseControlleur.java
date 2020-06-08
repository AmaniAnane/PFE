package com.example.demo.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.ChoixRespositor;
import com.example.demo.dao.QuestionsRespository;
import com.example.demo.entities.Choixreponse;
import com.example.demo.entities.Questions;

public class ChoixreponseControlleur {
	@Autowired
	private QuestionsRespository  questionsRespository;

	@Autowired
	private ChoixRespositor choixRespositor;
	 
	
	 @RequestMapping(value="/ChoixReponseQuestion/", method = RequestMethod.GET)
	 public String crationChoixReponce(Model model, int num) {
		
		 Questions q=questionsRespository.findById(num).get();
		 model.addAttribute("Questions",q);
		  
		 model.addAttribute("Choixreponse",new Choixreponse() );
		 return "crationChoixReponce";
	 }
	 
	 

	 @RequestMapping(value="Choixreponse/save/{num}", method=RequestMethod.POST)
	 public String saveReponse(@PathVariable("num") int questionsId,@Valid @ModelAttribute Choixreponse R, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
		 return "crationChoixReponce";
		 }
		 Questions q=questionsRespository.findById(questionsId).get();
		R.setCh(q);
		choixRespositor.save(R);
		
		return "redirect:/Questions/lister";
	 
	 }

	 
	 
}
