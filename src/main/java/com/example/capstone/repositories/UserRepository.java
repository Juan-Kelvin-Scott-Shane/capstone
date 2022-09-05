package com.example.capstone.repositories;

import com.example.capstone.models.Genre;
import com.example.capstone.models.Proficiency;
import com.example.capstone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public interface UserRepository extends JpaRepository <User, Long>{
    User findByUsername(String username);
    User findByVerificationCode(String code);
    User findByEmail(String email);

    User findUsersByCityLikeAndStateLike(String city, String state);
//    @Query("From User u, Proficiency p WHERE u.userType =?1 and p.genre.id=?1")
//    List<User> findUsersByUserType(@Param("userType"))


    @Query("select u from User u inner join u.proficiencies pr where pr.genre.id = ?1 AND u.userType = ?2")
    List<User> findUserWithGenre(Long genre_id, String userType);

//    @Query("select u from User where city like ?1 and state like ?2")
//    List<User> findVenueByLocation(String city, String state);





}
