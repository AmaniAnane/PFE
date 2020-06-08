package com.example.demo.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.TypeRespository;
import com.example.demo.entities.Type;
@Controller
public class TypeControlleur {
	


@Autowired
private TypeRespository TypeRespository;
	 //Type
	 @RequestMapping("/Type/add")
	 public String AddType(Model model) {
		 model.addAttribute("Type",new Type() );
		 
		 return "addType";
		 }
		 

		 @RequestMapping(value="Type/save", method=RequestMethod.POST)
		 public String saveType(@Valid @ModelAttribute Type p, BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
			 return "addType";
			 }
			 TypeRespository.save(p);
			
			return "redirect:/Type/lister";
		 
		 }
		 
		 @RequestMapping("/Type/lister")
		 public String listTypes(Model model)
		 {
			 model.addAttribute("Type", TypeRespository.findAll());
			 return "Types";
		 }
		 
		
		 @RequestMapping("Type/update")
		 public String modifType(Model model,int num) {
			 Type p=TypeRespository.findById(num).get();
			 model.addAttribute("Type",p);
			 return "modifType";
		 }
		 @RequestMapping(value="/Type/modifier",method=RequestMethod.POST)
		 public String updateType(@Valid @ModelAttribute Type p,BindingResult bindingResult) {
			 if(bindingResult.hasErrors()) {
				 return "modifType";
			 }
			 TypeRespository.saveAndFlush(p);
			 return "redirect:/Type/lister";
		 }
		 
}
