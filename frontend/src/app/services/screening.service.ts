import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ScreeningModel} from "../models/screening-model";
import {AllScreenings} from "../models/all-screenings";

const BASEURL = "http://localhost:8080/api/screenings"
@Injectable({
  providedIn: 'root'
})
export class ScreeningService {

  constructor(private http: HttpClient) { }

  addScreening(data:ScreeningModel){
    return this.http.post(BASEURL, data);
  }

  allScreenings():Observable<AllScreenings[]>{
  return this.http.get<AllScreenings[]>(BASEURL)
  }



}
