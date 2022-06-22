package com.yhsong.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yhsong.projectmanager.models.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	// FIND ALL PROJECTS
	List<Project> findAll();
}
