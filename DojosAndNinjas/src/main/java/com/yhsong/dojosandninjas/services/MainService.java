package com.yhsong.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhsong.dojosandninjas.models.Dojo;
import com.yhsong.dojosandninjas.models.Ninja;
import com.yhsong.dojosandninjas.repositories.DojoRepository;
import com.yhsong.dojosandninjas.repositories.NinjaRepository;

@Service
public class MainService {
	// DEPENDENCY INJECTION OF REPOS
	@Autowired
	DojoRepository dojoRepo;
	
	@Autowired
	NinjaRepository ninjaRepo;
	
	// CREATE DOJO
	public Dojo createDojo(Dojo newDojo) {
		return dojoRepo.save(newDojo);
	}
	
	// GET ALL DOJOS
	public List<Dojo> getAllDojos() {
		return dojoRepo.findAll();
	}
	
	// GET ONE DOJO
	public Dojo getOneDojo(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}
	
	// UPDATE DOJO
	
	// DESTROY DOJO
	
	
	// CREATE NINJA
	public Ninja createNinja(Ninja newNinja) {
		return ninjaRepo.save(newNinja);
	}
	
	// GET ALL NINJAS
	public List<Ninja> getAllNinjas() {
		return ninjaRepo.findAll();
	}

	
	// GET ONE NINJA
	
	// UPDATE NINJA
	
	// DESTROY NINJA
}
