package com.athlete.runnig.Controller;

import com.athlete.runnig.entity.Athlete;
import com.athlete.runnig.entity.Event;
import com.athlete.runnig.request.athleteRequest;
import com.athlete.runnig.request.eventRequest;
import com.athlete.runnig.service.eventService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/events")
public class eventController {

    private eventService eventService;

    @GetMapping()
    public List<Event> getEvents() {
        return eventService.getAllEvents();
    }
    @PostMapping("/create")
    public Event createEvent(@RequestBody eventRequest request){
        return eventService.createEvent(request);
    }
    @PutMapping ("/update/{id}")
    public Event updateEvent(@RequestBody eventRequest request, @PathVariable Long id){
        return eventService.updateEvent(request, id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok("Evento com o ID: " + id + " foi excluído com sucesso!");
    }

    @PatchMapping("/updatePATCH/{id}")
    public Event updateEventPATCH(@RequestBody eventRequest request, @PathVariable Long id) {
        return eventService.updateEventPATCH( id, request);
    }
}
