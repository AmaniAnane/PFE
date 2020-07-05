package com.example.demo.web;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.CategorieRespository;
import com.example.demo.dao.QuestionnaireRespository;
import com.example.demo.dao.QuestionsRespository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.Questionnaire;
import com.example.demo.entities.Questions;
import com.example.demo.entities.User;


@Controller
public class QuestionnaireControlleur {
	


@Autowired
private QuestionsRespository  questionsRespository;
@Autowired
private QuestionnaireRespository QuestionnaireRespository;
@Autowired
private CategorieRespository CategorieRespository; 
@Autowired
 private UserRepository UserRespository;
	 @RequestMapping("/Questionnaire")
		public String index(Model model ,Principal principal)
		 {
			 String name= principal.getName();
			 User user=UserRespository.getUserByUsername(name);
			 model.addAttribute("user",user);
			List<Questionnaire> Questionnaire = (List<Questionnaire>) QuestionnaireRespository.findAll();
			model.addAttribute("Questionnaire", Questionnaire);
	    	return "Questionnaires";
	    }
	
	    @RequestMapping(value = "/add")
	    public String addStudent(Model model,Principal principal)
		 {
			 String name= principal.getName();
			 User user=UserRespository.getUserByUsername(name);
			 model.addAttribute("user",user);
	    	model.addAttribute("Questionnaire", new Questionnaire());
	        return "addQuestionnaire";
	    }	
		
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    
	    public String save(Questionnaire Questionnaire){
	    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    	   LocalDateTime now = LocalDateTime.now();  
	    	   String date =dtf.format(now);
	    	   Questionnaire.setDate(date);
	    	QuestionnaireRespository.save(Questionnaire);
	    	return "redirect:/Questionnaire";
	    }
	    
	    @RequestMapping(value ="/delete/{id_questionnaire}", method = RequestMethod.GET)
	    public String editRemoveEmployee(@PathVariable("id_questionnaire") int questionnaireId, Model model) {
	    	QuestionnaireRespository.deleteById(questionnaireId);
	        return "redirect:/Questionnaire";
	    }    
	 
	 
	 
	 @RequestMapping(value = "/addQuestionnaireQuestions/{id}", method = RequestMethod.GET)
	    public String addQuestions(@PathVariable("id") int questionnaireId, Model model,Principal principal)
		 {
			 String name= principal.getName();
			 User user=UserRespository.getUserByUsername(name);
			 model.addAttribute("user",user);
	    	Questionnaire q=QuestionnaireRespository.findById(questionnaireId).get();
			model.addAttribute("Questionnaire", q);
			model.addAttribute("question",questionsRespository.findAll());
			return "addQuestionnaireQuestions";
	    }
	    
	 //QuestionnaireQuestions
	 
		
	    
	    @RequestMapping(value="/Questionnaire/{id}/Questionss", method=RequestMethod.GET)
		public String QuestionnairesAddQuestions(@PathVariable int id, @RequestParam int QuestionsId, Model model) {
	    	Questions Questions = questionsRespository.findById(QuestionsId).get();
			Questionnaire Questionnaire = QuestionnaireRespository.findById(id).get();

			if (Questionnaire != null) {
				if (!Questionnaire.hasQuestions(Questions)) {
					Questionnaire.getQuestionss().add(Questions);
				}
				QuestionnaireRespository.save(Questionnaire);
				model.addAttribute("Questionnaire", QuestionnaireRespository.findById(id));
				model.addAttribute("Questionss", questionsRespository.findAll());
				return "redirect:/Questionnaire";
			}

			return "redirect:/Questionnaire";
		}    
	    
	    @RequestMapping(value = "getQuestionnaire", method = RequestMethod.GET)
	    public @ResponseBody List<Questionnaire> getQuestionnaire() {
	            return (List<Questionnaire>)QuestionnaireRespository.findAll();
	    }    


	    
	    
	    
	 
}
