package com.example.demo.web;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.CategorieRespository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.User;
@Controller
public class CategorieControlleur {


@Autowired

private CategorieRespository CategorieRespository;
@Autowired
private UserRepository UserRespository;
	 @RequestMapping("/Categorie/add")
	 public String AddCategorie(Model model,Principal principal)
	 {
		 String name= principal.getName();
		 User user=UserRespository.getUserByUsername(name);
		 model.addAttribute("user",user);
		 model.addAttribute("Categorie",new Categorie() );
		 
		 return "AddCategorie";
		 }
		 
 
	 
		 @RequestMapping(value="Categorie/save", method=RequestMethod.POST)
		 public String saveCategorie(@Valid @ModelAttribute Categorie a, BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
			 return "AddCategorie";
			 }
			CategorieRespository.save(a);
			
			return "redirect:/Categorie/lister";
		 
		 }
		 
		 
		 
		 
		 @RequestMapping("/Categorie/lister")
		 public String listCategorie(Model model,Principal principal)
		 {
			 String name= principal.getName();
			 User user=UserRespository.getUserByUsername(name);
			 model.addAttribute("user",user);
			 model.addAttribute("Categorie", CategorieRespository.findAll());
			 return "Categorie";
		 }
		 
		 
		
		 @RequestMapping("Categorie/update")
		 public String modifCategorie(Model model,int num,Principal principal)
		 {
			 String name= principal.getName();
			 User user=UserRespository.getUserByUsername(name);
			 model.addAttribute("user",user);
			 Categorie a=CategorieRespository.findById(num).get();
			 model.addAttribute("Categorie",a);
			 return "modifCategorie";
		 }
		 
		 
		 
		 @RequestMapping(value="/Categorie/modifier",method=RequestMethod.POST)
		 public String updateCategorie(@Valid @ModelAttribute Categorie a,BindingResult bindingResult) {
			 if(bindingResult.hasErrors()) {
				 return "modifCategorie";
			 }
			 CategorieRespository.saveAndFlush(a);
			 return "redirect:/Categorie/lister";
		 }
		 

		 
		 
		 
		 @RequestMapping(value="/Categorie/delete",method=RequestMethod.GET)
			public String deleteCategorie(Categorie a, int num) {
			 CategorieRespository.deleteById(num);
				
				return "redirect:/Categorie/lister";
			}
		 
		 
}
