import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { NewScreeningComponent } from './components/new-screening/new-screening.component';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {ReactiveFormsModule} from "@angular/forms";
import { AllScreeningsComponent } from './components/all-screenings/all-screenings.component';
import { ReservationComponent } from './components/reservation/reservation.component';
import { AllReservationsComponent } from './components/all-reservations/all-reservations.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    NewScreeningComponent,
    AllScreeningsComponent,
    ReservationComponent,
    AllReservationsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
