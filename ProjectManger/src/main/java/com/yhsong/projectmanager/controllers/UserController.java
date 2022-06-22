package com.yhsong.projectmanager.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yhsong.projectmanager.models.LoggedUser;
import com.yhsong.projectmanager.models.Project;
import com.yhsong.projectmanager.models.User;
import com.yhsong.projectmanager.services.ProjectService;
import com.yhsong.projectmanager.services.UserService;



@Controller
public class UserController {
	// DENPENDENCY INJECTION
			@Autowired
			UserService userServ;
			
			@Autowired
			ProjectService pServ;
			
			@GetMapping("/")
			public String index(Model model) {
				model.addAttribute("newUser", new User());
		        model.addAttribute("newLogin", new LoggedUser());
				return "index.jsp";
			}
			
			@PostMapping("/register")
		    public String register(@Valid @ModelAttribute("newUser") User newUser, 
		            BindingResult result, Model model, HttpSession session) {
		        
		        // EXTRA VALIDATIONS AND CREATE NEW USER
		    	User user = userServ.register(newUser, result);
		        
		    	// VALIDATION FAILS
		        if(result.hasErrors()) {
		            model.addAttribute("newLogin", new LoggedUser());
		            return "index.jsp";
		        }
		        
		        // VALIDATION PASS 
		        // STORE THEIR ID IN DB
		        // THEN LOG THEM IN
		        session.setAttribute("user_id", user.getId());
		        return "redirect:/home";
		    }
		    
		    @PostMapping("/login")
		    public String login(@Valid @ModelAttribute("newLogin") LoggedUser newLogin, 
		            BindingResult result, Model model, HttpSession session) {
		        
		        // ADD NEW USER TO DB
		    	User user = userServ.login(newLogin, result);
		    	
		    	// VALIDATION FAILS
		        if(result.hasErrors()) {
		            model.addAttribute("newUser", new User());
		            return "index.jsp";
		        }
		    
		        // VALIDATION PASS 
		        // STORE THEIR ID IN DB
		        // THEN LOG THEM IN
		        session.setAttribute("user_id", user.getId());
		        return "redirect:/home";
		    }
		    
		    @GetMapping("/home")
		    public String home(
		    	Model model, HttpSession session
		    ) {
		    	// CHECK IF USER IS LOGGED IN
		    	if (session.getAttribute("user_id") == null) {
		    		return "redirect:/logout";
		    	}
		    	
		    	// RETRIEVE USER
		    	Long user_id = (Long) session.getAttribute("user_id");
		    	User loggedUser = userServ.getOneUser(user_id);
		    	
		    	// RETRIEVE ALL BOOKS
		    	List<Project> allProjects = pServ.allProjects();
		    	
		    	// SET USER & ALL BOOKS
		    	model.addAttribute("user", loggedUser);
		    	model.addAttribute("projects", allProjects);
		    	return "home.jsp";
		    }
		    
		    // LOG OUT
		    @GetMapping("/logout")
		    public String logOut(HttpSession session) {
		    	// SETTING userId TO NULL, and REDIRECT TO LOGIN AND REG
		    	session.setAttribute("user_id", null);
		    	return "redirect:/";
		    }
}
