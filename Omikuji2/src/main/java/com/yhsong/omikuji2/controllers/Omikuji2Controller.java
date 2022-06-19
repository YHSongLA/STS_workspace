package com.yhsong.omikuji2.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Omikuji2Controller {
	@RequestMapping("/")
	public String index() {
		return "omikuji.jsp";
	}
	@RequestMapping("/show")
	public String show() {
		return "showOmikuji.jsp";
	}
	@PostMapping("/submit")
	public String submit(
			@RequestParam(value="num") int num,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="animal") String animal,
			@RequestParam(value="message") String message,
			HttpSession session
			) {
		System.out.println("POST ROUTE");
		boolean numberSize = true;
		if(num < 5 || num > 25) {
			numberSize = false;
		}
		if(numberSize == false) {
			return "redirect:/";
		}
		session.setAttribute("num", num);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("animal", animal);
		session.setAttribute("message", message);
		return "redirect:/show";
	}

}