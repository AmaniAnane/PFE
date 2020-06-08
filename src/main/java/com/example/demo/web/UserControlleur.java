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

import com.example.demo.dao.FonctionRespository;
import com.example.demo.dao.UserRespository;
import com.example.demo.entities.Fonction;
import com.example.demo.entities.User;
@Controller
public class UserControlleur {
	
	@Autowired
	private UserRespository UserRespository;

	@Autowired
	private FonctionRespository FonctionRespository;
	
	
	//useradd
	@RequestMapping(value = { "/User/add" }, method = RequestMethod.GET)

	 public String AddUser(Model model) {
		 model.addAttribute("User",new User() );
		
	  ArrayList<Fonction> Fonction = (ArrayList<Fonction>) FonctionRespository.findAll();
	  model.addAttribute("Fonction", Fonction);
	 
	  
		 return "AddUser";
		 }
	//saveUser
	
	 @RequestMapping(value="User/save", method=RequestMethod.POST)
	 public String saveUser(@Valid @ModelAttribute User p, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			
		 return "AddUser";
		 }
		UserRespository.save(p);
		
		return "redirect:/User/lister";
	 
	 }
	 
	 
	 //listerUser

	 
	 @RequestMapping(value="/User/lister",method = RequestMethod.GET)
	 public String listUser(Model model)
	 {
		  
		 model.addAttribute("User", UserRespository.findAll());
		 model.addAttribute("Usernew",new User() );
		 return "User";
	 }
	 
	 
	 
	 @RequestMapping(value="/User/modifier",method=RequestMethod.POST)
	 public String updateUser(@Valid @ModelAttribute User p,BindingResult bindingResult) {
		 if(bindingResult.hasErrors()) {
			 return "modifUser";
		 }
		 UserRespository.saveAndFlush(p);
		 return "redirect:/User/lister";
	 }
	 

	 //deleteUser
	 @RequestMapping(value="/User/delete",method=RequestMethod.GET)
		public String deleteUser(User p, int num) {
		 UserRespository.deleteById(num);
			
			return "redirect:/User/lister";
		}
	 
	 
	 
}
