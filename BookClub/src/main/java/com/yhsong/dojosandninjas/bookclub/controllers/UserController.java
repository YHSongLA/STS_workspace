package com.yhsong.dojosandninjas.bookclub.controllers;

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

import com.yhsong.dojosandninjas.bookclub.models.Book;
import com.yhsong.dojosandninjas.bookclub.models.LoginUser;
import com.yhsong.dojosandninjas.bookclub.models.User;
import com.yhsong.dojosandninjas.bookclub.services.BookService;
import com.yhsong.dojosandninjas.bookclub.services.UserService;



@Controller
public class UserController {
		// DENPENDENCY INJECTION
		@Autowired
		UserService userServ;
		@Autowired
		BookService bookServ;
		
		
		@GetMapping("/")
		public String index(Model model) {
			model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		
		@PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
	        
	        // EXTRA VALIDATIONS AND CREATE NEW USER
	    	User user = userServ.register(newUser, result);
	        
	    	// VALIDATION FAILS
	        if(result.hasErrors()) {
	            model.addAttribute("newLogin", new LoginUser());
	            return "index.jsp";
	        }
	        
	        // VALIDATION PASS 
	        // STORE THEIR ID IN DB
	        // THEN LOG THEM IN
	        session.setAttribute("user_id", user.getId());
	        return "redirect:/home";
	    }
	    
	    @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
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
	    	List<Book> allBooks = bookServ.allBooks();
	    	// SET USER & ALL BOOKS
	    	model.addAttribute("user", loggedUser);
	    	model.addAttribute("books", allBooks);
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
