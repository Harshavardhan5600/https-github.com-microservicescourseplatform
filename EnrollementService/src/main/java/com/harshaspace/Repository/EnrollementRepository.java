package com.harshaspace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harshaspace.Entity.Enrollement;

@Repository
public interface EnrollementRepository extends JpaRepository<Enrollement, Long> {

}
