package com.yhsong.yardiproject.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yhsong.yardiproject.models.Course;
import com.yhsong.yardiproject.services.CourseService;

@Controller
public class CourseController {
	// DENPENDENCY INJECTION
	@Autowired
	private CourseService courseServ;
	
	// CREATE NEW COURSE
	@GetMapping("/new/course")
	public String newCourse(
		HttpSession session,
		@ModelAttribute("courseObj") Course emptyCourse,
		BindingResult result
	) {
		// CHECK IF USER IS LOGGED IN
		if (session.getAttribute("user_id") == null) {
			return "redirect/";
		}
		return "newCourse.jsp";
	}
	
	@PostMapping("/create/course")
	public String createCourse(
		@Valid @ModelAttribute("courseObj") Course filledCourse,
		BindingResult result
	) {
		// VALIDATION FAILED
		if (result.hasErrors()) {
			return "newCourse.jsp";
		}
		// VALIDATION PASSED
		else {
			courseServ.save(filledCourse);
			return "redirect:/home";
		}
	}
}
