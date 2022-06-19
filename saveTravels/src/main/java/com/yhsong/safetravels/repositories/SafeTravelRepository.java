package com.yhsong.safetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yhsong.safetravels.models.SafeTravel;

@Repository
public interface SafeTravelRepository extends CrudRepository<SafeTravel, Long>{
	// this method retrieves all the books from the database
	List<SafeTravel> findAll();
	
	// this method finds books with descriptions containing the search string
	List<SafeTravel> findByDescriptionContaining(String search);
	
	// this method counts how many titles contain a certain string
	Long countByNameContaining(String search);
	
	// this method deletes a book that starts with a specific title
	Long deleteByNameStartingWith(String search);
}
