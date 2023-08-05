import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ScreeningList} from "../models/ScreeningList";
import {Details4Reservation} from "../models/details4Reservation";
import {Observable} from "rxjs";
import {AllReservations} from "../models/all-reservations";

const BASEURL = "http://localhost:8080/api/reservations"
@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http: HttpClient) { }

  createReservation(data:ScreeningList){
    return this.http.post(BASEURL, data);
  }

  getDetailsForReservation():Observable<Details4Reservation[]> {
      return this.http.get<Details4Reservation[]>(BASEURL + "/data");
  }

  allReservations():Observable<AllReservations[]> {
    return this.http.get<AllReservations[]>(BASEURL);
  }
}
