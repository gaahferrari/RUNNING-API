package com.athlete.runnig.service;

import com.athlete.runnig.entity.Athlete;
import com.athlete.runnig.entity.Event;
import com.athlete.runnig.entity.Running;
import com.athlete.runnig.repository.athleteRepository;
import com.athlete.runnig.repository.eventRepository;
import com.athlete.runnig.repository.runningRepository;
import com.athlete.runnig.request.runningRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class runningService {
    private runningRepository runningRepository;
    private athleteRepository athleteRepository;

    private eventRepository eventRepository;

    public List<Running> getAllInfos() {
        return runningRepository.findAll();
    }

    public Running createRunningInfo(runningRequest request) {

        Athlete athlete = athleteRepository.findAllById(request.getAthleteId());
        Event event = eventRepository.findAllById(request.getEventId());

        log.info("" + request.getEventId());
        log.info("" + event);
        Running newRunning = Running.builder()
                .athlete(athlete)
               .event(event)
                .pace(request.getPace())
                .ranking(request.getRanking())
                .build();
        return runningRepository.save(newRunning);
    }

    public Running updateRunningInfo(runningRequest request, Long id) {
        Athlete athlete = athleteRepository.findAllById(request.getAthleteId());
        Event event = eventRepository.findAllById(request.getEventId());
        Running running = runningRepository.findAllById(id);
        running.setAthlete(athlete);
        running.setEvent(event);
        running.setPace(request.getPace());
        running.setRanking(request.getRanking());
        return runningRepository.save(running);
    }


    public void deleteRunningInfo(Long id) {
        runningRepository.deleteById(id);
    }

    public Running updateRunningInfoPATCH(Long id, runningRequest request) {
        Athlete athlete = athleteRepository.findAllById(request.getAthleteId());
        Event event = eventRepository.findAllById(request.getEventId());

        Running running = runningRepository.findAllById(id);
        if (athlete != null) {
           running.setAthlete(athlete);
        }
        if (event != null) {
            running.setEvent(event);
        }
        if (request.getPace() != null) {
            running.setPace(request.getPace());
        }
        if (request.getRanking() != null) {
            running.setRanking(request.getRanking());
        }

        return runningRepository.save(running);
    }
}
