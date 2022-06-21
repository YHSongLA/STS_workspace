package com.yhsong.dojosandninjas.bookclub.controllers;

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

import com.yhsong.dojosandninjas.bookclub.models.Book;
import com.yhsong.dojosandninjas.bookclub.services.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookServ;
	
	// CREATE NEW BOOK
	@GetMapping("/new/book")
	public String newBook(
		HttpSession session,
		@ModelAttribute("bookObj") Book emptyBook,
		BindingResult result
	) {
		// CHECK IF USER IS LOGGED IN
		if (session.getAttribute("user_id") == null) {
			return "redirect/";
		}
		return "newBook.jsp";
	}
	
	@PostMapping("/create/book")
	public String createBook(
		@Valid @ModelAttribute("bookObj") Book filledBook,
		BindingResult result
	) {
		// VALIDATION FAILED
		if (result.hasErrors()) {
			return "newBook.jsp";
		}
		// VALIDATION PASSED
		else {
			bookServ.save(filledBook);
			return "redirect:/home";
		}
	}
	
	// SHOW BOOK
	@GetMapping("/book/{id}")
	public String show(
		@PathVariable("id") Long id,
		Model model
	) {
		// GET ONE BOOK
		Book oneBook = bookServ.getOneBook(id);
		
		model.addAttribute("book", oneBook);
		
		return "showBook.jsp";
	}
	
	// UPDATE | EDIT BOOK
	@GetMapping("/edit/book/{id}")
	public String editBook(
		HttpSession session,
		@PathVariable("id") Long id,
		Model model
	) {
		// CHECK IF USER IS LOGGED IN
		if (session.getAttribute("user_id") == null) {
			return "redirect/";
		}
		
		// GET ONE BOOK
		Book oneBook = bookServ.getOneBook(id);
		// PASS ONE BOOK
		model.addAttribute("bookObj", oneBook);
		
		return "editBook.jsp";
	}
	
	@PutMapping("/edit/book/{id}")
	public String updateBook(
		Model model,
		@Valid @ModelAttribute("bookObj") Book filledBook,
		BindingResult result
	) {
		// VALIDATION FAILED
		if (result.hasErrors()) {
			return "editBook.jsp";
		}
		// VALIDATION PASSED
		else {
			bookServ.save(filledBook);
			return "redirect:/home";
		}
	}
}
