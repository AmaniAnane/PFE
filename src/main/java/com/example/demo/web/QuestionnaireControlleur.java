package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.CategorieRespository;
import com.example.demo.dao.QuestionnaireRespository;
import com.example.demo.dao.QuestionsRespository;

import com.example.demo.entities.Questionnaire;
import com.example.demo.entities.Questions;

public class QuestionnaireControlleur {
	


@Autowired
private QuestionsRespository  questionsRespository;
@Autowired
private QuestionnaireRespository QuestionnaireRespository;

private CategorieRespository CategorieRespository; 

	 @RequestMapping("/Questionnaire")
		public String index(Model model) {
			List<Questionnaire> Questionnaire = (List<Questionnaire>) QuestionnaireRespository.findAll();
			model.addAttribute("Questionnaire", Questionnaire);
	    	return "Questionnaires";
	    }
	
	    @RequestMapping(value = "add")
	    public String addStudent(Model model){
	    	model.addAttribute("Questionnaire", new Questionnaire());
	        return "addQuestionnaire";
	    }	
		
	    @RequestMapping(value = "save", method = RequestMethod.POST)
	    public String save(Questionnaire Questionnaire){
	    	QuestionnaireRespository.save(Questionnaire);
	    	return "redirect:/Questionnaire";
	    }
	    
	    @RequestMapping(value = "/delete/{id_questionnaire}", method = RequestMethod.GET)
	    public String editRemoveEmployee(@PathVariable("id_questionnaire") int questionnaireId, Model model) {
	    	QuestionnaireRespository.deleteById(questionnaireId);
	        return "redirect:/Questionnaire";
	    }    
	 
	 
	 
	 @RequestMapping(value = "addQuestionnaireQuestions/{id}", method = RequestMethod.GET)
	    public String addQuestions(@PathVariable("id") int questionnaireId, Model model){
	    	model.addAttribute("Questionss", questionsRespository.findAll());
	    	
			model.addAttribute("Questionnaire", QuestionnaireRespository.findById(questionnaireId).get());
			model.addAttribute("Categorie",CategorieRespository.findAll());
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
