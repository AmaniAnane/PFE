package com.example.demo.web;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import com.example.demo.dao.UserRepository;
//import com.example.demo.dao.UserRespository;
import com.example.demo.entities.Choixreponse;
import com.example.demo.entities.Questionnaire;
import com.example.demo.entities.Questions;
import com.example.demo.entities.Reponse;
import com.example.demo.entities.User;
@Controller
public class UserQuestionnairesOutoevaluerControlleur {
	
	@Autowired
	private ChoixRespositor choixRespositor;
	
	@Autowired
	private UserRepository UserRespository;

	@Autowired
	private QuestionsRespository  questionsRespository;
	@Autowired
	private QuestionnaireRespository QuestionnaireRespository;
	@Autowired 
	private ReponseRespositor ReponseRespositor;

	
	 @RequestMapping(value = "UserQuestionnaire/{id}", method = RequestMethod.GET)
	    public String UserQuestionnaire(@PathVariable("id") int UserId, Model model,Principal principal)
		 {
			 String name= principal.getName();
			 User user=UserRespository.getUserByUsername(name);
			 model.addAttribute("user",user);
		 
		 Singleton.getInstance().setUser(UserRespository.findById(UserId).get());
		 model.addAttribute("Questionnaires", UserRespository.findById(UserId).get().getQuestionnaires());
		
	
			model.addAttribute("User", UserRespository.findById(UserId).get());
			
	    	return "UserQuestionnaires";
	    }
	 
	 
	
	 
	 
	 @RequestMapping(value = { "/User/Questionnaire/" }, method = {RequestMethod.GET,RequestMethod.POST})

	 public String Questionnaire(Model model, int n, Principal principal) {
		 
		 model.addAttribute("Reponse",new Reponse() );

String name= principal.getName();
User user=UserRespository.getUserByUsername(name);
 model.addAttribute( "user" ,user);
		 
		// Singleton.getInstance().setUser(UserRespository.findById(id).get());
		 Singleton.getInstance().setQuestionnaire(QuestionnaireRespository.findById(n).get());
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
			 LocalDateTime now = LocalDateTime.now();  
	  	   String date =dtf.format(now);
		 model.addAttribute( "Questionnaire" ,QuestionnaireRespository.findById(n).get());
		 Singleton.getInstance().setUser(user);
		 return "UserQuestionnaire";
		 }
	 
	 
	 @RequestMapping(value = { "/User/Questions/" }, method = {RequestMethod.GET,RequestMethod.POST})

	 public String AddReponses(Model model, int n,Principal principal)
	 {
		 String name= principal.getName();
		 User user=UserRespository.getUserByUsername(name);
		 model.addAttribute("user",user);
		 model.addAttribute("Reponse",new Reponse() );
	
		 Questionnaire Questionnaire= Singleton.getInstance().getQuestionnaire();
		 
		 model.addAttribute( "Questions" ,questionsRespository.findById(n).get());
model.addAttribute( "User" ,UserRespository.findById(user.getId_User()).get());
		 model.addAttribute( "Questionnaire" ,QuestionnaireRespository.findById(Questionnaire.getId_questionnaire()).get());
		 Singleton.getInstance().setQuestions(questionsRespository.findById(n).get());
		 return "UserQuestions";
		 }
	 
	 

	
	 

	 @RequestMapping(value = { "/User/Reponses/" }, method = RequestMethod.GET)
	 public String saveReponseUser(@Valid @ModelAttribute Reponse Reponse, int[] ChoixreponseId,BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
				Questions Questions=Singleton.getInstance().getQuestions();
				int m=Questions.getId_question();
			 return "/User/Questions/?n="+m;
			 }
		
			
			for(int i=0; i<ChoixreponseId.length;i++)
		    {
				Choixreponse Choixreponses = choixRespositor.findById(ChoixreponseId[i]).get();
				
			 Reponse.setUser(Singleton.getInstance().getUser());
			 Reponse.setQuestionnaire(Singleton.getInstance().getQuestionnaire());
			 Questions Questions=Choixreponses.getCh();
		
			 Reponse.getChoixreponse().add(Choixreponses);
			 
			
			 
			 Reponse.setQuestions(Questions);
			
			
		
		     
			 ReponseRespositor.save(Reponse);
			 
			 
			
		 }
			int n= Singleton.getInstance().getQuestionnaire().getId_questionnaire();
	 

			return "redirect:/User/Questionnaire/?n="+n;
	 
}
	 }
