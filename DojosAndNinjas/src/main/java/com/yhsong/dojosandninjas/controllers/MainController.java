package com.yhsong.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yhsong.dojosandninjas.models.Dojo;
import com.yhsong.dojosandninjas.models.Ninja;
import com.yhsong.dojosandninjas.services.MainService;

@Controller
public class MainController {
	@Autowired
	MainService mainServ;
	
	// CREATE DOJO
	@GetMapping("/")
	public String index(
		@ModelAttribute("dojoObj") Dojo emptyDojo
	) {
		return "index.jsp";
	}
	
	@PostMapping("/new/dojo")
	public String createDojo(
		@Valid @ModelAttribute("dojoObj") Dojo filledDojo, BindingResult results,
		RedirectAttributes redirectAttributes
	) {
		// VALIDATION FAILS
		if (results.hasErrors()) {
			return "index.jsp";			
		}
		// VALIDATION PASS
		mainServ.createDojo(filledDojo);
		redirectAttributes.addFlashAttribute("success", "Dojo was successfully creted!");
		return "redirect:/new/ninja";			
	}
	
	
	// CREATE NINJA
	@GetMapping("/new/ninja")
	public String newNinja(
		@ModelAttribute("ninjaObj") Ninja emptyNinja,
		Model model
	) {
		// GRAB ALL DOJOS FROM DB
		List<Dojo> allDojos = mainServ.getAllDojos();
		// PASS THE LIST OF DOJOS TO JSP
		model.addAttribute("dojos", allDojos);
		return "newNinja.jsp";
	}
	
	@PostMapping("/create/ninja")
	public String newNinja(
		@Valid @ModelAttribute("ninjaObj") Ninja filledNinja, BindingResult results,
		RedirectAttributes redirectAttributes,
		Model model
	) {
		// VALIDATION FAILS
		if (results.hasErrors()) {
			// GRAB ALL DOJOS FROM DB
			List<Dojo> allDojos = mainServ.getAllDojos();
			// PASS THE LIST OF DOJOS TO JSP
			model.addAttribute("dojos", allDojos);
			return "newNinja.jsp";			
		}
		// VALIDATION PASS
		Ninja newNinja = mainServ.createNinja(filledNinja);
		redirectAttributes.addFlashAttribute("success", "Dojo was successfully created!");
		
		return "redirect:/dojos/" + newNinja.getLocations().getId();			
	}
	
	@GetMapping("/dojos/{id}")
	public String display(
		@PathVariable("id") Long id,
		Model model
	) {
		Dojo dojo = mainServ.getOneDojo(id);
		model.addAttribute("dojos", dojo);
		
		return "dojos.jsp";
	}
}
