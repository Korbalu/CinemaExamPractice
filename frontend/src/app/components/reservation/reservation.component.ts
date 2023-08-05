import {Component} from '@angular/core';
import {ScreeningModel} from "../../models/screening-model";
import {FormBuilder, FormGroup} from "@angular/forms";
import {ScreeningList} from "../../models/ScreeningList";
import {ReservationService} from "../../services/reservation.service";
import {Details4Reservation} from "../../models/details4Reservation";

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent {

  screenings!: Details4Reservation[];
  reservationForm: FormGroup

  constructor(private formBuilder: FormBuilder, private reservationService: ReservationService) {
    this.reservationForm = this.formBuilder.group({
      name: [''],
      seats: [0],
      screeningId: [0]
    });
    this.reservationService.getDetailsForReservation().subscribe({
      next: (screenings: Details4Reservation[]) => {this.screenings = screenings},
      error: () => {},
      complete: () => {console.log(this.screenings)}
    })
  }

  onSubmit() {
    this.reservationService.createReservation(this.reservationForm.value).subscribe({
      next: () => this.reservationForm.reset(),
      error: err => (console.log(err)),
      complete: () => {console.log("Account registered")}
    })
  }


}
