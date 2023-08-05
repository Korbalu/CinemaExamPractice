import { Component } from '@angular/core';
import {AllReservations} from "../../models/all-reservations";
import {ScreeningService} from "../../services/screening.service";
import {Router} from "@angular/router";
import {ReservationService} from "../../services/reservation.service";

@Component({
  selector: 'app-all-reservations',
  templateUrl: './all-reservations.component.html',
  styleUrls: ['./all-reservations.component.css']
})
export class AllReservationsComponent {

  reservations!: AllReservations[];

  constructor(private reservationService: ReservationService) {
    this.reservationService.allReservations().subscribe({
      next: data => this.reservations = data,
      error: error => console.log(error),
      complete: () => {}
    })
  }

}
