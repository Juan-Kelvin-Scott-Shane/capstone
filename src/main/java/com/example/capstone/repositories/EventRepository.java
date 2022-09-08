package com.example.capstone.repositories;

import com.example.capstone.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> {
    Event deleteEventById(Long id);
//    Event findEventByLocationLikeAndDate(String location, String date);
//    List<Event> findAllEventsByLocationContainsIgnoreCaseAndDate(String location, String date);
    List<Event> findEventsByCityContainingAndStateAndDate(String city, String state, String date);
}
