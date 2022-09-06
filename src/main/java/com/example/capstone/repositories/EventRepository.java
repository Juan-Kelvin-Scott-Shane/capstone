package com.example.capstone.repositories;

import com.example.capstone.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
    Event deleteEventById(Long id);
    Event findEventByLocationAndDate(String location, String date);
}
