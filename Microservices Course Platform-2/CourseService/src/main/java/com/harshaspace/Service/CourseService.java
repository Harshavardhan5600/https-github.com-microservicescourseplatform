package com.harshaspace.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshaspace.Entity.Course;
import com.harshaspace.Repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getallcourses() {
		return courseRepository.findAll();
	}
	
	public Course savecourse(Course course) {
		return courseRepository.save(course);
	}
	
	public Course updatecourse(Long id, String name, String description) {
		Course course = courseRepository.findById(id).get();
		course.setName(name);
		course.setDescription(description);
		Course updatedcourse = courseRepository.save(course);
		return updatedcourse;
	}
	
	public String deletebyId(Long id) {
		courseRepository.deleteById(id);
		return "Deleted Successfully";
	}

}
