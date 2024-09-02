import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { OffenseDetails } from '../offenseDetails';
import { OffensesService } from '../service/offenses.service';
import { Observable, of } from 'rxjs';
import { map, startWith } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Offense } from '../offense';
import { Registration } from '../registration';

@Component({
  selector: 'app-raise-offense',
  templateUrl: './raise-offense.component.html',
  styleUrls: ['./raise-offense.component.css']
})
export class RaiseOffenseComponent implements OnInit {

  raiseForm: FormGroup;
  offenseDetails: OffenseDetails;
  registration: Registration;
  offenseTypes: Offense[] = [];
  filteredOffenses: Observable<any[]>;

  constructor(private offense: OffensesService, private http: HttpClient) { }

  async ngOnInit() {
    this.raiseForm = new FormGroup({
      place: new FormControl('', Validators.required),
      image: new FormControl(),
      registration: new FormControl('',
        [
          Validators.required,
          Validators.pattern("^[A-Z]{2} [0-9]{2} [A-Z]{1,2} [0-9]{4}$")
        ]),
      offensetype: new FormControl('', Validators.required),
      // user: new FormControl('U001'), 
      // penaltyStatus: new FormControl("Unpaid")  
    });

    this.http.get("http://localhost:7070/TMS/tms/cop/getOffenseTypes")
      .subscribe((response: any) => {
        this.offenseTypes = response;
        console.log(this.offenseTypes, typeof this.offenseTypes);

        this.filteredOffenses = this.raiseForm.get('offensetype').valueChanges.pipe(
          startWith(''),
          map((value: string) => this._filter(value))
        );
      });
  }

  private _filter(value: string): Offense[] {
    const filterValue = value.toLowerCase();
    return this.offenseTypes.filter(offense =>
      offense.offenseId.toLowerCase().includes(filterValue) ||
      offense.offenseName.toLowerCase().includes(filterValue)
    );
  }

  displayOffense(offense: Offense) {
    if (offense)
      return `${offense.offenseId} - ${offense.offenseName}`;
    return "";
  }

  async reportOffense() {
    // this.offenseDetails = this.raiseForm.value;
    const response = await this.http.get("http://localhost:7070/TMS/tms/cop/getRegDetails?registrationNo=" + this.raiseForm.value.registration).toPromise();
    this.registration = response as Registration;
    if(!this.registration) alert("Enter a valid registration number.")
    console.log("Reg details : ", this.registration);
    this.offenseDetails = {
      "offenseDetailId": "OFD0" + Math.floor(Math.random() * 1000),
      "dateTime": new Date().toLocaleString(),
      "place": this.raiseForm.value.place,
      "img": this.raiseForm.value.image ? this.raiseForm.value.image : "",
      "offense": this.raiseForm.value.offensetype,
      "registration": this.registration,
      "user": {
        "userId": "U002",
        "userName": "Bhagya",
        "password": "Bhagya@123",
        "email": "bhagyshreeph12@gmail.com",
        "role": {
          "roleName": "Clerk",
          "roleDesc": "One who can raise offense"
        }
      },
      "penaltyStatus": "unpaid"
    };
    console.log(this.offenseDetails);
  
    await this.offense.addOffenses(this.offenseDetails).then(response => {
      console.log("response : ", response); // handle the response
      // do something with the response
    }).catch(error => {
      console.error(error.error.text); // handle the error
      if(error.error.text) alert("Offense reported.!")
    });
    
  }
}
