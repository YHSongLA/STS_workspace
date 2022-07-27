package com.yhsong.yardiproject.controllers;

import java.util.List;

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

import com.yhsong.yardiproject.models.Course;
import com.yhsong.yardiproject.models.LoginUser;
import com.yhsong.yardiproject.models.Purchase;
import com.yhsong.yardiproject.models.User;
import com.yhsong.yardiproject.services.CourseService;
import com.yhsong.yardiproject.services.PurchaseService;
import com.yhsong.yardiproject.services.UserService;


@Controller
public class UserController {
	// DENPENDENCY INJECTION
	@Autowired
	UserService userServ;
	
	@Autowired
	PurchaseService purchaseServ;
	
	@Autowired
	CourseService courseServ;
	
	
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
//    	// CHECK IF USER IS LOGGED IN
//    	if (session.getAttribute("user_id") == null) {
//    		return "redirect:/logout";
//    	}
    	
    	// RETRIEVE USER
    	Long user_id = (Long) session.getAttribute("user_id");
    	
    	// IF USER IS NOT LOGGED IN
    	// ! If user is not logged in, user can still access home page.
    	if (user_id != null) {    		
    		User loggedUser = userServ.getOneUser(user_id);
    		model.addAttribute("user", loggedUser);
    	}
    	
    	// RETRIEVE ALL BOOKS
    	List<Course> allCourses = courseServ.getAllCourse();
    	
    	// SET USER & ALL BOOKS
    	model.addAttribute("courses", allCourses);
    	return "home.jsp";
    	
    	// ADD TO CART BUTTON
    	
    }
    
    @GetMapping("/account/{id}")
    public String account(
    	@PathVariable("id") Long id,
    	HttpSession session,
    	Model model
    ) {
    	// CHECK IF USER IS LOGGED IN
		if (session.getAttribute("user_id") == null) {
			return "redirect/";
		}
		// GET ONE USER
		User oneUser = userServ.getOneUser(id);
		
		// GET ALL PURCHASES
		List<Purchase> allPurchases = purchaseServ.getAllPurchases();
		
		// PASS ONE USER
		model.addAttribute("user", oneUser);
		
		// PASS ALL PURCHASES
		model.addAttribute("purchases", allPurchases);
		
    	return "accountPage.jsp";
    }
    
    // LOG OUT
    @GetMapping("/logout")
    public String logOut(HttpSession session) {
    	// SETTING userId TO NULL, and REDIRECT TO LOGIN AND REG
    	session.invalidate();
    	return "redirect:/home";
    }
}
