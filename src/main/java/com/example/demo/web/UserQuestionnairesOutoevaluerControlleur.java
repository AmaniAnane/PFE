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
import com.example.demo.dao.QuestionnaireRespository;
import com.example.demo.dao.QuestionsRespository;
import com.example.demo.dao.ReponseRespositor;
import com.example.demo.dao.Singleton;
import com.example.demo.dao.UserRespository;
import com.example.demo.entities.Choixreponse;
import com.example.demo.entities.Questionnaire;
import com.example.demo.entities.Questions;
import com.example.demo.entities.Reponse;
import com.example.demo.entities.User;

public class UserQuestionnairesOutoevaluerControlleur {
	
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

	
	 @RequestMapping(value = "UserQuestionnaire/{id}", method = RequestMethod.GET)
	    public String UserQuestionnaire(@PathVariable("id") int UserId, Model model){
	    
		 
		 Singleton.getInstance().setUser(UserRespository.findById(UserId).get());
		 model.addAttribute("Questionnaires", UserRespository.findById(UserId).get().getQuestionnaires());
		
	
			model.addAttribute("User", UserRespository.findById(UserId).get());
			
	    	return "UserQuestionnaires";
	    }
	 
	 
	 
	 @RequestMapping(value = { "/User/Questionnaire/" }, method = {RequestMethod.GET,RequestMethod.POST})

	 public String Questionnaire(Model model, int n) {
		 model.addAttribute("Reponse",new Reponse() );
		 User user= Singleton.getInstance().getUser();
		 model.addAttribute( "User" ,UserRespository.findById(user.getId_User()).get());
		 
		// Singleton.getInstance().setUser(UserRespository.findById(id).get());
		 Singleton.getInstance().setQuestionnaire(QuestionnaireRespository.findById(n).get());
		 model.addAttribute( "Questionnaire" ,QuestionnaireRespository.findById(n).get());

		 return "UserQuestionnaire";
		 }
	 
	 
	 @RequestMapping(value = { "/User/Questions/" }, method = {RequestMethod.GET,RequestMethod.POST})

	 public String AddReponses(Model model, int n) {
		 model.addAttribute("Reponse",new Reponse() );
	
		 User user= Singleton.getInstance().getUser();
		 Questionnaire Questionnaire= Singleton.getInstance().getQuestionnaire();
		 
		 model.addAttribute( "Questions" ,questionsRespository.findById(n).get());
		 model.addAttribute( "User" ,UserRespository.findById(user.getId_User()).get());
		 model.addAttribute( "Questionnaire" ,QuestionnaireRespository.findById(Questionnaire.getId_questionnaire()).get());
		 Singleton.getInstance().setQuestions(questionsRespository.findById(n).get());
		 return "UserQuestions";
		 }
	 
	 


	 @RequestMapping(value = { "/User/Reponses/" }, method = RequestMethod.GET)
	 public String saveReponseUser(@Valid @ModelAttribute Reponse Reponse, int ChoixreponseId,BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
				Questions Questions=Singleton.getInstance().getQuestions();
				int m=Questions.getId_question();
			 return "/User/Questions/?n="+m;
			 }
		
			 Reponse.setUser(Singleton.getInstance().getUser());
			 Reponse.setQuestionnaire(Singleton.getInstance().getQuestionnaire());
			
			Choixreponse Choixreponses = choixRespositor.findById(ChoixreponseId).get();
			
			 Reponse.getChoixreponse().add(Choixreponses);
			 Questions Questions=Singleton.getInstance().getQuestions();
			
			 
			 Reponse.setQuestions(Questions);
			
			
			int n= Singleton.getInstance().getQuestionnaire().getId_questionnaire();
		     
			 ReponseRespositor.save(Reponse);
			 
			
			return "redirect:/User/Questionnaire/?n="+n;
		 }
	 
	 
	 //test
	 @RequestMapping("/testtemplete/{id}")
	 public String test(@PathVariable("id") int UserId, Model model){
		   
		 Singleton.getInstance().setUser(UserRespository.findById(UserId).get());
		 model.addAttribute("Questionnaires", UserRespository.findById(UserId).get().getQuestionnaires());
		
			model.addAttribute("User", UserRespository.findById(UserId).get());
		
			
		
			 
			 
	    	return "form_wizards";
	    }
}
