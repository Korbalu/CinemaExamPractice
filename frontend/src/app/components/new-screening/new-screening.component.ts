import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ScreeningService} from "../../services/screening.service";
import {Router} from "@angular/router";
import {validationHandler} from "../../utils/validation-handler";

@Component({
  selector: 'app-new-screening',
  templateUrl: './new-screening.component.html',
  styleUrls: ['./new-screening.component.css']
})
export class NewScreeningComponent {
  screeningForm: FormGroup

  constructor(private screeningService: ScreeningService, private formBuilder: FormBuilder,
  private router: Router) {
    this.screeningForm = formBuilder.group({
      title: ["",Validators.required],
      screeningDate: ["",Validators.required],
      totalSeat: [0,Validators.required],
      pictureUrl: [""],
    })
  }

  onSubmit() {
    let data = this.screeningForm.value;
    console.log(data)
    this.screeningService.addScreening(data).subscribe({
      next: value => {},
      error: err => {
        console.log(err);
        validationHandler(err, this.screeningForm);
        },
      complete:()=>{console.log("Screenings page requested"), this.router.navigate(["/all-screenings"])}
    })
  }
}
