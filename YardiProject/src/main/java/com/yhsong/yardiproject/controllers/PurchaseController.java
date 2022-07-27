package com.yhsong.yardiproject.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yhsong.yardiproject.models.Course;
import com.yhsong.yardiproject.services.CartService;
import com.yhsong.yardiproject.services.CourseService;
import com.yhsong.yardiproject.services.PurchaseService;
import com.yhsong.yardiproject.services.UserService;

@Controller
public class PurchaseController {
	// DENPENDENCY INJECTION
	@Autowired
	PurchaseService purchaseServ;
	
	@Autowired
	CartService cartServ;
	
	@Autowired
	UserService userServ;
	
	@Autowired
	CourseService courseServ;
	
	@GetMapping("/carts")
	public String displayCarts(
			HttpSession session,
			Model model		
			) {
		
		
		return "carts.jsp";
	}
	
	@PostMapping("/carts")
	public String carts(
		HttpSession session,
		Model model,
		@RequestParam("course_id") Long course_id
	) {
		// CHECK IF USER IS LOGGED IN
		if (session.getAttribute("user_id") == null) {
			return "redirect/";
		}
		// IF NEW USER CREATES A CART
		if(session.getAttribute("cart") == null) {
			ArrayList<Course> courses = new ArrayList<Course>();
			session.setAttribute("cart", courses);
		}
		
		@SuppressWarnings("unchecked")
		ArrayList<Course> carts = (ArrayList<Course>) session.getAttribute("cart");
		Course courseToAdd = courseServ.getOneCourse(course_id);
		carts.add(courseToAdd);
		session.setAttribute("cart", carts);
		
		
		// RETRIEVE ALL COURSES
//		List<Course> allCourses = courseServ.getAllCourse();
		
		// SET ALL COURSES
//		model.addAttribute("courses", allCourses);
		
		return "redirect:/carts";
	}
	
	// CHECKOUT PAGE
	@GetMapping("/checkout")
	public String checkout() {
		return "checkout.jsp";
	}
	
	@GetMapping("/purchase/order")
	public String purchase() {
		return "purchaseOrder.jsp";
	}
	
	// DESTROY
	@GetMapping("/destroy/{id}")
	public String destroy(
		@PathVariable("id") Long id
	) {
		courseServ.deleteCourse(id);
		return "redirect:/carts";
	}
}
