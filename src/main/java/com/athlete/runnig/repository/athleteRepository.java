package com.athlete.runnig.repository;

import com.athlete.runnig.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface athleteRepository extends JpaRepository<Athlete, Long> {
    Athlete findAllById(Long id);

    Athlete findAllByName(String name);
}
