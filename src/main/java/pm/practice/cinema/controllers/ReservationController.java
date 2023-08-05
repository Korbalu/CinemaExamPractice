package pm.practice.cinema.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pm.practice.cinema.dto.incoming.ReservationCommand;
import pm.practice.cinema.dto.incoming.ScreeningCommand;
import pm.practice.cinema.dto.outgoing.ReservationListItem;
import pm.practice.cinema.dto.outgoing.ScreeningDetails;
import pm.practice.cinema.services.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Void> addReservation(@RequestBody ReservationCommand command){
        reservationService.addReservation(command);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/data")
    public ResponseEntity<List<ScreeningDetails>> sendDetails (){
        return new ResponseEntity<>(reservationService.getDetails(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ReservationListItem>> getList(){
        return new ResponseEntity<>(reservationService.getBookings(), HttpStatus.OK);
    }
}
