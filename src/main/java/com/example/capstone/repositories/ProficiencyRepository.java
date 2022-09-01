package com.example.capstone.repositories;

import com.example.capstone.models.Proficiency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProficiencyRepository extends JpaRepository<Proficiency,Long > {
	Proficiency findByGenre(String id);
	Proficiency findProficienciesByGenre(String id);
	Proficiency findByUserId(String id);
	Proficiency deleteById(String id);
}
