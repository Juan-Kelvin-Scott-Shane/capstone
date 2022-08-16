package com.example.capstone.repositories;

import com.example.capstone.models.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentRepository extends JpaRepository<Instrument,Long> {
}
