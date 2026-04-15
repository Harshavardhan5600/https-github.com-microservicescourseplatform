package com.harshaspace.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshaspace.Entity.Enrollement;
import com.harshaspace.Repository.EnrollementRepository;

@Service
public class EnrollementService {
	
	@Autowired
	private EnrollementRepository enrollementRepository;
	
	public Enrollement saveEnroll(Enrollement enrollement) {
		return enrollementRepository.save(enrollement);
	}
	
	public List<Enrollement> getall() {
		return enrollementRepository.findAll();
	}

}
