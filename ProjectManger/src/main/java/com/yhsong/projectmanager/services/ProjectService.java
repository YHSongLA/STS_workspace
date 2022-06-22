package com.yhsong.projectmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhsong.projectmanager.models.Project;
import com.yhsong.projectmanager.repositories.ProjectRepository;



@Service
public class ProjectService {
	// DENPENDENCY INJECTION
		@Autowired
		private ProjectRepository projectRepo;

		// find all the projects
		public List<Project> allProjects() {
			return projectRepo.findAll();
		}
		
		// get one project
		public Project getOneProject(Long id) {
			return projectRepo.findById(id).orElse(null);
		}
		
		// CREATE | UPDATE PROJECT
		public Project save(Project projectObj) {
			return projectRepo.save(projectObj);
		}


		// Delete Project
		public void deleteProject(Long id) {
			projectRepo.deleteById(id);
		}
}
