package com.yhsong.safetravels.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhsong.safetravels.models.SafeTravel;
import com.yhsong.safetravels.repositories.SafeTravelRepository;

@Service
public class SafeTravelService {
	@Autowired
	private final SafeTravelRepository safeTravelRepo;
	
	public SafeTravelService(SafeTravelRepository safeTravelRepository) {
		this.safeTravelRepo = safeTravelRepository;
	}
	
	// GET ALL THE SAFETRAVELS
	public List<SafeTravel> allSafeTravels() {
		return safeTravelRepo.findAll();
	}
	
	// CREATE SAFETRAVEL
	public SafeTravel createSafeTravel(SafeTravel s) {
		return safeTravelRepo.save(s);
	}
	
	// GET ONE SAFETRAVEL
	public SafeTravel getOneSafeTravel(Long id) {
		return safeTravelRepo.findById(id).orElse(null);
	}
	
	// GET ONE SAFETRAVEL
	public SafeTravel findSafeTravel(Long id) {
		Optional<SafeTravel> optionalSafeTravel = safeTravelRepo.findById(id);
		if (optionalSafeTravel.isPresent()) {
			return optionalSafeTravel.get();
		}
		else {
			return null;
		}
	}
	
	// UPDATE SAFETRAVEL
	public SafeTravel updateSafeTravel(Long id, String name, String vendor, double amount, String description) {
		SafeTravel safeTravel = this.findSafeTravel(id);
		safeTravel.setName(name);
		safeTravel.setVendor(vendor);
		safeTravel.setAmount(amount);
		safeTravel.setDescription(description);
		return safeTravelRepo.save(safeTravel);
	}
	
	// DELETE SAFETRAVEL
	public void deleteSafeTravel(Long id) {
		safeTravelRepo.deleteById(id);
	}

	public SafeTravel updateSafeTravel(@Valid SafeTravel updatedSafeTravel) {
		return safeTravelRepo.save(updatedSafeTravel);
	}

}
