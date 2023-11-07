package com.athlete.runnig.repository;

import com.athlete.runnig.entity.Running;
import org.springframework.data.jpa.repository.JpaRepository;

public interface runningRepository extends JpaRepository<Running, Long> {
    Running findAllById(Long id);
}
