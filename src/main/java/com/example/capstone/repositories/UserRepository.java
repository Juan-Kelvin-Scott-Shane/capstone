package com.example.capstone.repositories;

import com.example.capstone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{
    User findByUsername(String username);
    User findByVerificationCode(String code);

}
