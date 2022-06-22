package com.yhsong.projectmanager.controllers;

import javax.servlet.http.HttpSession;
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

import com.yhsong.projectmanager.models.Project;
import com.yhsong.projectmanager.services.ProjectService;


@Controller
public class ProjectController {
	@Autowired
	private ProjectService pServ;
	
	// CREATE NEW PROJECT
	@GetMapping("/new/project")
	public String newProject(
		HttpSession session,
		@ModelAttribute("projectObj") Project emptyProject,
		BindingResult result
	) {
		// CHECK IF USER IS LOGGED IN
		if (session.getAttribute("user_id") == null) {
			return "redirect/";
		}
		return "newProject.jsp";
	}
	
	@PostMapping("/create/project")
	public String createProject(
		@Valid @ModelAttribute("projectObj") Project filledProject,
		BindingResult result
	) {
		// VALIDATION FAILED
		if (result.hasErrors()) {
			return "newProject.jsp";
		}
		// VALIDATION PASSED
		else {
			pServ.save(filledProject);
			return "redirect:/home";
		}
	}
	
	// SHOW PROJECT
	@GetMapping("/project/{id}")
	public String show(
		@PathVariable("id") Long id,
		Model model
	) {
		// GET ONE BOOK
		Project oneProject = pServ.getOneProject(id);
			
		model.addAttribute("project", oneProject);
			
		return "showProject.jsp";
	}
	
	// UPDATE | EDIT PROJECT
	@GetMapping("/edit/project/{id}")
	public String editProject(
		HttpSession session,
		@PathVariable("id") Long id,
		Model model
	) {
		// CHECK IF USER IS LOGGED IN
		if (session.getAttribute("user_id") == null) {
			return "redirect/";
		}
		
		// GET ONE PROJECT
		Project oneProject = pServ.getOneProject(id);
		// PASS ONE PROJECT
		model.addAttribute("projectObj", oneProject);
		
		return "editProject.jsp";
	}
	
	@PutMapping("/edit/project/{id}")
	public String updateProject(
		Model model,
		@Valid @ModelAttribute("projectObj") Project updatedProject,
		BindingResult result
	) {
		// VALIDATION FAILED
		if (result.hasErrors()) {
			return "editProject.jsp";
		}
		// VALIDATION PASSED
		else {
			pServ.save(updatedProject);
			return "redirect:/home";
		}
	}
	
	// DESTROY
	@GetMapping("/destroy/{id}")
	public String destroy(
		@PathVariable("id") Long id
	) {
		pServ.deleteProject(id);
		return "redirect:/home";
	}
	
}
