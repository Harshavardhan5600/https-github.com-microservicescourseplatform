package com.harshaspace.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshaspace.Entity.Enrollement;
import com.harshaspace.Service.EnrollementService;

@RestController
@RequestMapping("/enrollement")
public class EnrollementController {
	
	@Autowired
	private EnrollementService enrollementService;
	
	@PostMapping("/save")
	public Enrollement saveEnroll(@RequestBody Enrollement enrollement) {
		return enrollementService.saveEnroll(enrollement);
	}
	
	@GetMapping("/fetchall")
	public List<Enrollement> getall() {
		return enrollementService.getall();
	}

}
