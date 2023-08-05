package pm.practice.cinema.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pm.practice.cinema.dto.incoming.ScreeningCommand;
import pm.practice.cinema.dto.outgoing.ScreeningListItem;
import pm.practice.cinema.services.ScreeningService;
import pm.practice.cinema.validators.ScreeningValidators;

import java.util.List;

@RestController
@RequestMapping("/api/screenings")
public class ScreeningController {
    private ScreeningService screeningService;
    private ScreeningValidators screeningValidators;

    public ScreeningController(ScreeningService screeningService, ScreeningValidators screeningValidators) {
        this.screeningService = screeningService;
        this.screeningValidators = screeningValidators;
    }

    @InitBinder("screeningCommand")
    protected void initScreeningBinder(WebDataBinder binder) {
        binder.addValidators(screeningValidators);
    }

    @PostMapping
    public ResponseEntity<Void> addScreening(@RequestBody @Valid ScreeningCommand command){
        screeningService.addScreening(command);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ScreeningListItem>> allScreenings(){
        return new ResponseEntity<>(screeningService.listAllScreenings(), HttpStatus.OK);
    }
}
