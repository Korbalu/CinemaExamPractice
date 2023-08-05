import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {NewScreeningComponent} from "./components/new-screening/new-screening.component";
import {AllScreeningsComponent} from "./components/all-screenings/all-screenings.component";
import {ReservationComponent} from "./components/reservation/reservation.component";
import {AllReservationsComponent} from "./components/all-reservations/all-reservations.component";

const routes: Routes = [
  {path: "new-screening", component:NewScreeningComponent},
  {path: "all-screenings", component:AllScreeningsComponent},
  {path: "reservation", component:ReservationComponent},
  {path: "all-reservations", component:AllReservationsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
