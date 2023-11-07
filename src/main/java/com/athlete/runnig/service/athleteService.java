package com.athlete.runnig.service;

import com.athlete.runnig.entity.Athlete;
import com.athlete.runnig.repository.athleteRepository;
import com.athlete.runnig.request.athleteRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class athleteService {
    private athleteRepository athleteRepository;

    public List<Athlete> getAllAthletes() {
        return athleteRepository.findAll();
    }

    public Athlete getAthletesByName(String name) {
        return athleteRepository.findAllByName(name);
    }

    public Athlete createAthlete(athleteRequest request) {
        Athlete newAthlete = Athlete.builder()
                .name(request.getName())
                .age(request.getAge())
                .category(request.getCategory())
                .CPF(request.getCpf())
                .build();
        return athleteRepository.save(newAthlete);
    }

    public Athlete updateAthlete(athleteRequest request, Long id) {
        Athlete athlete = athleteRepository.findAllById(id);
        athlete.setName(request.getName());
        athlete.setAge(request.getAge());
        athlete.setCPF(request.getCpf());
        return athleteRepository.save(athlete);
    }

    public void deleteAthlete(Long id) {
        athleteRepository.deleteById(id);
    }

    public Athlete updateAthletePATCH(Long id, athleteRequest request) {
        Athlete athlete = athleteRepository.findAllById(id);
        if (request.getName() != null) {
            athlete.setName(request.getName());
        }
        if (request.getCategory() != null) {
            athlete.setCategory(request.getCategory());
        }
        if (request.getAge() != null) {
            athlete.setAge(request.getAge());
        }
        if (request.getCpf() != null) {
            athlete.setCPF(request.getCpf());
        }
        return athleteRepository.save(athlete);
    }
}


