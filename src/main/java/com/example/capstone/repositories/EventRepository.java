package com.example.capstone.repositories;

import com.example.capstone.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> {
    Event deleteEventById(Long id);
    List<Event> findEventsByCityContainingAndStateAndDate(String city, String state, String date);
}
