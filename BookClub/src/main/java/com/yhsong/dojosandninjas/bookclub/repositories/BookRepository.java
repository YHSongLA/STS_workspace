package com.yhsong.dojosandninjas.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yhsong.dojosandninjas.bookclub.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	// FIND ALL BOOKS
	List<Book> findAll();
}
