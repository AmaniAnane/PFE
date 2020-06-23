package com.example.demo.web;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.ChoixRespositor;
import com.example.demo.dao.QuestionsRespository;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Choixreponse;
import com.example.demo.entities.Questionnaire;
import com.example.demo.entities.Questions;
import com.example.demo.entities.User;
@Controller
public class ChoixreponseControlleur {
	@Autowired
	private QuestionsRespository  questionsRespository;

	@Autowired
	private ChoixRespositor choixRespositor;
	
	/*
	 @RequestMapping(value="/ChoixReponseQuestion/", method = RequestMethod.GET)
	 public String crationChoixReponce(Model model, int num) {
		
		 Questions q=questionsRespository.findById(num).get();
		 model.addAttribute("Questions",q);
		  
		 model.addAttribute("Choixreponse",new Choixreponse() );
		 return "crationChoixReponce";
	 }*/
	 
	 @RequestMapping(value="Questions/choixReponse", method = RequestMethod.GET)
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
		
		choixRespositor.save(R);
		
		return "redirect:/Questions/lister";
	 
	 }
/*
	 
	    @RequestMapping(value="/User/{id}/Questionnaires", method=RequestMethod.GET)
		public String UsersAddQuestionnaire(@PathVariable int id, @RequestParam int QuestionnaireId, Model model) {
	    	Questionnaire Questionnaire = QuestionnaireRespository.findById(QuestionnaireId).get();
	    	User User = UserRespository.findById(id).get();

			if (User != null) {
				if (!User.hasQuestionnaire(Questionnaire)) {
					User.getQuestionnaires().add(Questionnaire);
				}
				UserRespository.save(User);
				model.addAttribute("User", UserRespository.findById(id));
				model.addAttribute("Questionnaires", QuestionnaireRespository.findAll());
				return "redirect:/User/lister";
			}

			return "redirect:/User/lister";
		}  */
	 
	 @RequestMapping(value="Choixreponse/update/", method=RequestMethod.GET)
	 public String modifQuestions(Model model,int num, @RequestParam int id)
			 {
		 Choixreponse ch=choixRespositor.findById(num).get();
		 Questions q=questionsRespository.findById(id).get();
		 model.addAttribute("Choixreponse",ch);
		 model.addAttribute("Questions",q);
		 
		
		 return "modifChoixreponse";
	 }
	 @RequestMapping(value="/Choixreponse/modifier",method=RequestMethod.POST)
	 public String updateChoixreponse(@Valid @ModelAttribute Choixreponse ch,BindingResult bindingResult) {
		 if(bindingResult.hasErrors()) {
			 return "modifChoixreponse";
		 }
		 choixRespositor.saveAndFlush(ch);
		 return "redirect:/Questions/lister";
	 }
	 
	 @RequestMapping(value="/Choixreponse/delete",method=RequestMethod.GET)
		public String deleteChoixreponse(Choixreponse ch, int num) {
		 choixRespositor.deleteById(num);
			
			return "redirect:/Questions/lister";
		}
	 
	 
}
