package com.yhsong.daikichipathvariables.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaikichiController {
	
	@RequestMapping("/")
	public String hello() {
		return "Hello World!";
	}
	
	@RequestMapping("/daikichi")
	public String welcome() {
		return "Welcome!";
	}
	
	@RequestMapping("/daikichi/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	
	@RequestMapping("/daikichi/tomorrow")
	public String tomorrow() {
		return "Tomorrow an opportunity will arise, so be sure to be open to new ideas!";
	}
	
	@RequestMapping("/daikichi/travel/{cities}")
	public String cities(@PathVariable("cities") String c) {
		return "Congratulations! You will soon travel to " + c + "!";
	}
	
	@RequestMapping("/daikichi/lotto/{num}")
	public String lotto(@PathVariable("num") int n) {
		if (n % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers.";
		}
		return "You have enjoyed the fruits of your labor. but now is a great time to spend time with family and friends.";
	}
	
}
