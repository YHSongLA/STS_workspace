package com.yhsong.yardiproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhsong.yardiproject.models.Course;
import com.yhsong.yardiproject.repositories.CourseRepository;

@Service
public class CourseService {
	// DEPENDENCY INJECT
	@Autowired
	private CourseRepository courseRepo;
	
	// FIND ALL THE COURSES
	public List<Course> getAllCourse() {
		return courseRepo.findAll();
	}
	
	// GET ONE COURSE
	public Course getOneCourse(Long id) {
		return courseRepo.findById(id).orElse(null);
	}
	
	// CREATE | EDIT
	public Course save(Course courseObj) {
		return courseRepo.save(courseObj);
	}
	
	// DESTROY
	public void deleteCourse(Long id) {
		courseRepo.deleteById(id);
	}
}
