package com.example.demo.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.FonctionRespository;
import com.example.demo.entities.Fonction;
@Controller
public class FonctionControlleur {
	 // Fonction 
	@Autowired
	private FonctionRespository FonctionRespository;
	
	 @RequestMapping("/Fonction/add")
	 public String AddFonction(Model model) {
		 model.addAttribute("Fonction",new Fonction() );
		 
		 return "addFonction";
		 }
		 

		 @RequestMapping(value="Fonction/save", method=RequestMethod.POST)
		 public String saveFonction(@Valid @ModelAttribute Fonction p, BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
			 return "addFonction";
			 }
			FonctionRespository.save(p);
			
			return "redirect:/User/add";
		 
		 }
		 
		 @RequestMapping("/Fonction/lister")
		 public String listFonction(Model model)
		 {
			 model.addAttribute("Fonction", FonctionRespository.findAll());
			 return "Fonction";
		 }
		 
		 
		 @RequestMapping("Fonction/update")
		 public String modifFonction(Model model,int num) {
			 Fonction p=FonctionRespository.findById(num).get();
			 model.addAttribute("Fonction",p);
			 return "modifFonction";
		 }
		 @RequestMapping(value="/Fonction/modifier",method=RequestMethod.POST)
		 public String updateFonction(@Valid @ModelAttribute Fonction p,BindingResult bindingResult) {
			 if(bindingResult.hasErrors()) {
				 return "modifFonction";
			 }
			 FonctionRespository.saveAndFlush(p);
			 return "redirect:/Fonction/lister";
		 }
		 
		 @RequestMapping(value="/Fonction/delete",method=RequestMethod.GET)
			public String deleteFonction(Fonction p, int num) {
			 FonctionRespository.deleteById(num);
				
				return "redirect:/Fonction/lister";
			}
		 
}
