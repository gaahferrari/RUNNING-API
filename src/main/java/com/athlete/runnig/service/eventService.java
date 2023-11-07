package com.athlete.runnig.service;


import com.athlete.runnig.entity.Event;
import com.athlete.runnig.repository.eventRepository;
import com.athlete.runnig.request.eventRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class eventService {
    private eventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event createEvent(eventRequest request) {
        Event newEvent = Event.builder()
                .name(request.getName())
                .eventDate(request.getEventDate())
                .eventTime(request.getEventTime())
                .address(request.getAddress())
                .price(request.getPrice())
                .studentPrice(request.getStudentPrice())
                .build();
        return eventRepository.save(newEvent);
    }

    public Event updateEvent(eventRequest request, Long id) {
        Event event = eventRepository.findAllById(id);
        event.setName(request.getName());
        event.setEventDate(request.getEventDate());
        event.setEventTime(request.getEventTime());
        event.setAddress(request.getAddress());
        event.setPrice(request.getPrice());
        event.setStudentPrice(request.getStudentPrice());
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public Event updateEventPATCH(Long id, eventRequest request) {
        Event event = eventRepository.findAllById(id);
        if (request.getName() != null) {
            event.setName(request.getName());
        }
        if (request.getEventDate() != null) {
            event.setEventDate(request.getEventDate());
        }
        if (request.getEventTime() != null) {
            event.setEventTime(request.getEventTime());
        }
        if (request.getAddress() != null) {
            event.setAddress(request.getAddress());
        }
        if (request.getPrice() != null) {
            event.setPrice(request.getPrice());
        }
        if (request.getStudentPrice() != null) {
            event.setStudentPrice(request.getPrice());
        }
        return eventRepository.save(event);
    }
}
