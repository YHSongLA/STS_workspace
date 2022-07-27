package com.yhsong.yardiproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yhsong.yardiproject.models.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{
	// FIND ALL COURSES
	List<Course> findAll();
}
