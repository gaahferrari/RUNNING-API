package com.athlete.runnig.Controller;

import com.athlete.runnig.entity.Athlete;
import com.athlete.runnig.request.athleteRequest;
import com.athlete.runnig.service.athleteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/athlete")
public class athleteController {

    private athleteService athleteService;
    @GetMapping()
    public List<Athlete> getAthletes() {
        return athleteService.getAllAthletes();
    }
    @GetMapping("/{name}")
    public Athlete athleteWithPathVariable(@PathVariable String name) {
        return athleteService.getAthletesByName(name);
    }
    @GetMapping("/query")
    public Athlete athleteWithQuery(@RequestParam(value = "name") String name) {
        return athleteService.getAthletesByName(name);
    }
    @PostMapping("/create")
    public Athlete createAthlete(@RequestBody athleteRequest request){
        return athleteService.createAthlete(request);
    }

    @PutMapping ("/update/{id}")
    public Athlete updateAthlete(@RequestBody athleteRequest request, @PathVariable Long id){
        return athleteService.updateAthlete(request, id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAthlete(@PathVariable Long id) {
       athleteService.deleteAthlete(id);
        return ResponseEntity.ok("Atleta com o ID: " + id + " foi excluído com sucesso!");
    }
    @PatchMapping("/updatePATCH/{id}")
    public Athlete updateAthletePATCH(@RequestBody athleteRequest request, @PathVariable Long id) {
        return athleteService.updateAthletePATCH( id, request);
    }
}
