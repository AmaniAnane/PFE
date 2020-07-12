package com.example.demo.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.FonctionRespository;
import com.example.demo.entities.Role;
import com.example.demo.dao.RoleRespository;
import com.example.demo.dao.UserRepository;
//import com.example.demo.dao.UserRespository;
import com.example.demo.entities.Fonction;
import com.example.demo.entities.Questionnaire;
import com.example.demo.entities.Questions;
import com.example.demo.entities.User;
@Controller
public class UserControlleur {
	
	@Autowired
	private UserRepository UserRespository;
	
	@Autowired
	private RoleRespository RoleRespository;

	@Autowired
	private FonctionRespository FonctionRespository;
	
	
	//useradd
	@RequestMapping(value = { "/User/add" }, method = RequestMethod.GET)

	 public String AddUser(Model model,Principal principal)
	 {
		 String name= principal.getName();
		 User user=UserRespository.getUserByUsername(name);
		 model.addAttribute("user",user);
		 model.addAttribute("User",new User() );
		
	  ArrayList<Fonction> Fonction = (ArrayList<Fonction>) FonctionRespository.findAll();
	  model.addAttribute("Fonction", Fonction);
	
		model.addAttribute("Role",RoleRespository.findAll());
	  
			

	  
		 return "AddUser";
		 }
	//saveUser
	
	 @RequestMapping(value="User/save", method=RequestMethod.POST)
	 public String saveUser(@Valid @ModelAttribute User p,@RequestParam int id ,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			
		 return "AddUser";
		 }
		Role r = RoleRespository.findById(id).get();
		p.getRoles().add(r);
	    String encodedPassword = new BCryptPasswordEncoder().encode(p.getPassword());
	    p.setPassword(encodedPassword);
	p.setEnabled(true);
	    UserRespository.save(p);
	    
		
		return "redirect:/User/lister";
	 
	 }
	
	 
	 //listerUser

	 
	 @RequestMapping(value="/User/lister",method = RequestMethod.GET)
	 public String listUser(Model model,Principal principal)
	 {
		 String name= principal.getName();
		 User user=UserRespository.getUserByUsername(name);
		 model.addAttribute("user",user);
		  
		 model.addAttribute("User", UserRespository.findAll());
		 model.addAttribute("Usernew",new User() );
		 return "User";
	 }
	 //upadeprofile
	 
	 @RequestMapping("upadate/profile")
	 public String modifprofile(Model model,int num,Principal principal)
	 {
		 String name= principal.getName();
		 User user=UserRespository.getUserByUsername(name);
		 model.addAttribute("user",user);
		 User p=UserRespository.findById(num).get();
		 model.addAttribute("User",p);
	
		 return "modifprofile";
	 }
	 @RequestMapping(value="/modifer/Profile",method=RequestMethod.POST)
	 public String updateProfile(@Valid @ModelAttribute User p,BindingResult bindingResult,@RequestParam int id) {
		 if(bindingResult.hasErrors()) {
			 return "modifprofile";
		 }
		 
	
			Role r = RoleRespository.findById(id).get();
			p.getRoles().add(r);
			
		    String encodedPassword = new BCryptPasswordEncoder().encode(p.getPassword());
		    p.setPassword(encodedPassword);
		 UserRespository.saveAndFlush(p);
		 return "redirect:/";
	 }
	 
	 
	 //updateUser
	 @RequestMapping("User/update")
	 public String modifUser(Model model,int num,Principal principal)
	 {
		  ArrayList<Fonction> Fonction = (ArrayList<Fonction>) FonctionRespository.findAll();
		  model.addAttribute("Fonction", Fonction);
		 
		 String name= principal.getName();
		 User user=UserRespository.getUserByUsername(name);
		 model.addAttribute("user",user);
		 model.addAttribute("Role",RoleRespository.findAll());
		 User p=UserRespository.findById(num).get();
		 model.addAttribute("User",p);
		 Fonction fonctionUser =p.getU();

		 model.addAttribute("fonctionUser",fonctionUser);
		 
		 return "modifUser";
	 }
	
	 @RequestMapping(value="/User/modifier",method=RequestMethod.POST)
	 public String updateUser(@Valid @ModelAttribute User p,BindingResult bindingResult,@RequestParam int id) {
		 if(bindingResult.hasErrors()) {
			 return "modifUser";
		 }
	
			Role r = RoleRespository.findById(id).get();
			p.getRoles().add(r);
		    String encodedPassword = new BCryptPasswordEncoder().encode(p.getPassword());
		    p.setPassword(encodedPassword);
		 UserRespository.saveAndFlush(p);
		 return "redirect:/User/lister";
	 }
	 

	 //deleteUser
	 @RequestMapping(value="/User/delete",method=RequestMethod.GET)
		public String deleteUser(User p, int num) {
		User u=UserRespository.findById(num).get();
		 
	
		 UserRespository.deleteById(num);
		
			return "redirect:/User/lister";
		}
	 
	 
	 
}
