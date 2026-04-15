package com.harshaspace.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshaspace.Entity.Course;
import com.harshaspace.Service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/getall")
	public List<Course> getallcourses() {
		return courseService.getallcourses();
	}
	
	@PostMapping("/save")
	public Course savecourse(@RequestBody Course course) {
		return courseService.savecourse(course);
	}
	
	@PutMapping("/update")
	public Course updatecourse(@PathVariable Long id, @RequestBody String name, @RequestBody String description ) {
		Course course = courseService.updatecourse(id, name, description);
		course.setName(name);
		course.setDescription(description);
		Course updatedcourse = courseService.updatecourse(id, name, description);
		return updatedcourse;
	}
	
	@DeleteMapping("/delete")
	public String deletebyId(@PathVariable Long id) {
		return courseService.deletebyId(id);
	}
	
	
	
	
	
	
	
	
	
	
	

}
