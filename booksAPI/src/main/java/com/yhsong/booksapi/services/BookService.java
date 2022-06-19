package com.yhsong.booksapi.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhsong.booksapi.models.Book;
import com.yhsong.booksapi.repositories.BookRepository;

@Service
public class BookService {
	// adding the book repository as a dependency
	@Autowired
	private final BookRepository bookRepo;

 
	public BookService(BookRepository bookRepository) {
		this.bookRepo = bookRepository;
	}
	// returns all the books
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	// get one book
	public Book getOneBook(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	// creates a book
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	// Update Book
	public Book updateBook(Long id, String title, String desc, String lang, Integer pages) {
		Book book = this.findBook(id);
		book.setTitle(title);
		book.setDescription(desc);
		book.setLanguage(lang);
		book.setNumberOfPages(pages);
		return bookRepo.save(book);
	}

	// Delete Book
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
}

