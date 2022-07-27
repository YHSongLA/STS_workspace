package com.yhsong.yardiproject.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yhsong.yardiproject.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	// FIND ALL USERS
	List<User> findAll();
				
	// CUSTOM QUERY
	Optional<User> findByEmail(String email);
}
