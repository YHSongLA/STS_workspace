package com.yhsong.yardiproject.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.yhsong.yardiproject.models.LoginUser;
import com.yhsong.yardiproject.models.User;
import com.yhsong.yardiproject.repositories.UserRepository;

@Service
public class UserService {
	// DEPENDENCY INJECTION
	@Autowired
	UserRepository userRepo;
			
	
	public User register(User newUser, BindingResult result) {
	    // Reject if email is taken (present in database)
		Optional<User> user = userRepo.findByEmail(newUser.getEmail());
	    	
	    if(user.isPresent()) {
	    	// USER EMAIL IS ALREADY TAKEN
	    	result.rejectValue("email", "Duplicate", "Email already taken");
	    }
	    // Reject if password doesn't match confirmation
	    if(!newUser.getPassword().equals(newUser.getConfirm())) {
	    	result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
	    }
	    // Return null if result has errors
	    if(result.hasErrors()) {
	    	return null;
	    }
	    
	    // Hash and set password, save user to database
	    String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
	    newUser.setPassword(hashed);
	    userRepo.save(newUser);
	    return newUser;
	}
	    
	
	public User login(LoginUser newLogin, BindingResult result) {
	    // Find user in the DB by email
	    // Reject if NOT present
	    	
	    if(!this.checkEmail(newLogin.getEmail())) {
	    	result.rejectValue("email", "Non-Existant", "INVALID CREDENTIALS");
	    }
	    if(result.hasErrors()) {
	    	return null;
	    }
	    	
	        
	    // Reject if BCrypt password match fails
	    User user = userRepo.findByEmail(newLogin.getEmail()).orElse(null);
	    if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
	    	result.rejectValue("password", "Matches", "Invalid Password!");
	    }
	    
	    // Return null if result has errors
	    if(result.hasErrors()) {
	    	return null;
	    }
	    	// Otherwise, return the user object
	    	return user;
	    }
	    
	public boolean checkEmail(String email) {
	    Optional<User> user = userRepo.findByEmail(email);
	    	
	    if(user.isPresent()) {
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}

	// GET ONE USER
	public User getOneUser(Long id) {
		return userRepo.findById(id).orElse(null);
	}

	// FIND USER BY ID 
	public Object findById(Long id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
			return null;
		}


	// GET ALL USERS
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
		
	// DESTROY
}
