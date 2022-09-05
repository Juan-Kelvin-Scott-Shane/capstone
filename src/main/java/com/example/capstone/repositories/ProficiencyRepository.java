package com.example.capstone.repositories;

import com.example.capstone.models.Genre;
import com.example.capstone.models.Instrument;
import com.example.capstone.models.Proficiency;
import com.example.capstone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProficiencyRepository extends JpaRepository<Proficiency,Long > {
	Proficiency findByGenre(String id);
	Proficiency findProficienciesByGenre(String id);


}
