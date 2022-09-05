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
	@Query("FROM Proficiency p where p.skill =?1")
	List<Proficiency> findProficienciesSkillLIKE(@Param("title")String title);
	Proficiency findProficienciesByGenre(Genre genre);

	Proficiency findProficienciesByUserIdAndGenre(User user, Genre genre);

//	@Query("From Proficiency p where p.genre.title")
//			List<Proficiency> findProficienciesByGenreLike(@Param("title")String title);
	Proficiency findProficienciesByGenreOrInstruments(Genre genre, Instrument instrument);
	Proficiency findProficienciesByGenreAndInstruments(Genre genre, Instrument instrument);

	@Query("From Proficiency p WHERE p.instruments.instName like %:name%")
	List<Proficiency> findProficienciesByInstrumentsLike(@Param("name")String name);

	@Query("From Proficiency p WHERE p.genre.title like %:title% AND p.instruments.instName LIKE %:name%")
	List<Proficiency>findProficienciesByGenreTitleLikeAndInstrumentsInstName(@Param("title")String title, @Param("name")String name);

	@Query ("From Proficiency p Where p.user.city Like %:city%")
	List<Proficiency>findProficienciesByUserCityLike(@Param("city")String city);

	Proficiency findByUserId(String id);
}
