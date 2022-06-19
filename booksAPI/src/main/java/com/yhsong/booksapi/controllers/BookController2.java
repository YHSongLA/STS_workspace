package com.yhsong.booksapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yhsong.booksapi.models.Book;
import com.yhsong.booksapi.services.BookService;

@Controller
public class BookController2 {
	@Autowired
	private BookService bookServ;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		// GRAB ONE BOOK FROM DB - BookService bookServ
		Book oneBook = bookServ.findBook(id);
		model.addAttribute("book", oneBook);
		return "showBook.jsp";
	}
	
	@PostMapping("/submit")
	public String submit(
			@RequestParam(value="title") String title,
			@RequestParam(value="desc") String desc, 
	    	@RequestParam(value="lang") String lang,
	    	@RequestParam(value="pages") int pages,
	    	Model model
	) {
		model.addAttribute("title", title);
		model.addAttribute("desc", desc);
		model.addAttribute("lang", lang);
		model.addAttribute("pages", pages);
		
		Book newBook = new Book(title, desc, lang, pages);
		bookServ.createBook(newBook);
		return "redirect:/books/{id}";
	}
}
