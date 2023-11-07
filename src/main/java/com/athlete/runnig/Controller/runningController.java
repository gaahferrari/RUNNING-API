package com.athlete.runnig.Controller;

import com.athlete.runnig.request.runningRequest;
import com.athlete.runnig.service.eventService;
import com.athlete.runnig.service.runningService;
import com.athlete.runnig.entity.Running;
import com.athlete.runnig.request.eventRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/running")
public class runningController {

    private runningService runningService;

    @GetMapping()
    public List<Running> getRunningInfos() {
        return runningService.getAllInfos();
    }
    @PostMapping("/create")
    public Running createRunningInfo(@RequestBody runningRequest request){
        return runningService.createRunningInfo(request);
    }
    @PutMapping ("/update/{id}")
    public Running updateRunningInfo(@RequestBody runningRequest request, @PathVariable Long id){
        return runningService.updateRunningInfo(request, id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRunningInfo(@PathVariable Long id) {
        runningService.deleteRunningInfo(id);
        return ResponseEntity.ok("Informações com o ID: " + id + " foi excluído com sucesso!");
    }

    @PatchMapping("/updatePATCH/{id}")
    public Running updateRunningInfoPATCH(@RequestBody runningRequest request, @PathVariable Long id) {
        return runningService.updateRunningInfoPATCH( id, request);
    }
}
