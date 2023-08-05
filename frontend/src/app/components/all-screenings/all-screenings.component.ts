import {Component} from '@angular/core';
import {AllScreenings} from "../../models/all-screenings";
import {ScreeningService} from "../../services/screening.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-all-screenings',
  templateUrl: './all-screenings.component.html',
  styleUrls: ['./all-screenings.component.css']
})
export class AllScreeningsComponent {

  screens!: AllScreenings[];

  constructor(private screeningService: ScreeningService, private router: Router) {
    this.screeningService.allScreenings().subscribe({
      next: data => this.screens = data,
      error: error => console.log(error),
      complete: () => {
      }
    })
  }
}
