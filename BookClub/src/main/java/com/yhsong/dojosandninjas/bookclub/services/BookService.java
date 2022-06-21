package com.yhsong.dojosandninjas.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhsong.dojosandninjas.bookclub.models.Book;
import com.yhsong.dojosandninjas.bookclub.repositories.BookRepository;

@Service
public class BookService {
	// DENPENDENCY INJECTION
	@Autowired
	private BookRepository bookRepo;

	// find all the books
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	// get one book
	public Book getOneBook(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	
	// CREATE | UPDATE BOOK
	public Book save(Book bookObj) {
		return bookRepo.save(bookObj);
	}


	// Delete Book
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
