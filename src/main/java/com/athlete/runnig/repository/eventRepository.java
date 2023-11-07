package com.athlete.runnig.repository;

import com.athlete.runnig.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface eventRepository extends JpaRepository<Event, Long> {
    Event findAllById(Long id);
}
