package com.yhsong.safetravels.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;

import com.yhsong.safetravels.models.SafeTravel;
import com.yhsong.safetravels.services.SafeTravelService;

@Controller
public class SafeTravelController {
	@Autowired
	private SafeTravelService safeTravelServ;
	
	@GetMapping("/")
	public String index(
			@ModelAttribute("safeTravelObj") SafeTravel emptySafeTravel,
			Model model
	) {
		List<SafeTravel> allSafeTravels = safeTravelServ.allSafeTravels();
		
		model.addAttribute("safeTravels", allSafeTravels);
		
		return "index.jsp";
	}
	
	@PostMapping("/create/data")
	public String create(
			@Valid @ModelAttribute("safeTravelObj") SafeTravel filledSafeTravel,
			BindingResult results, Model model
	) {
		if (results.hasErrors()) {
			List<SafeTravel> allSafeTravels = safeTravelServ.allSafeTravels();
			
			model.addAttribute("safeTravels", allSafeTravels);
			
			return "index.jsp";
		}
		else {
			safeTravelServ.createSafeTravel(filledSafeTravel);
			return "redirect:/";
		}
	}
	
	// UPDATE
	@GetMapping("/edit/{id}")
	public String edit(
			@PathVariable("id") Long id,
			Model model
	) {
		SafeTravel editSafeTravel = safeTravelServ.getOneSafeTravel(id);
		
		model.addAttribute("safeTravelObj", editSafeTravel);
		
		return "edit.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String update(
			@Valid @ModelAttribute("safeTravelObj") SafeTravel updatedSafeTravel,
			BindingResult results
	) {
		// Validation Failed
		if (results.hasErrors()) {
			return "edit.jsp";
		}
		else {
			safeTravelServ.updateSafeTravel(updatedSafeTravel);
			return "redirect:/";
		}
	}
	
	// DESTROY
	@GetMapping("/destroy/{id}")
	public String destroy(@PathVariable("id") long id) {
		safeTravelServ.deleteSafeTravel(id);
		return "redirect:/";
	}
}
