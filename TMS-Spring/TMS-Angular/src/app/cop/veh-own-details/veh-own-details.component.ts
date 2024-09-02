import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Owner } from '../owner';
import { Vehicle } from '../vehicle';
import { RegistrationService } from '../service/registration.service';
import { Registration } from '../registration';

@Component({
  selector: 'app-veh-own-details',
  templateUrl: './veh-own-details.component.html',
  styleUrls: ['./veh-own-details.component.css']
})
export class VehOwnDetailsComponent implements OnInit {

  searchForm: FormGroup;
  owner: Owner;
  vehicle: Vehicle;
  registrationNo: string;
  registration: Registration;

  constructor(private regService: RegistrationService) { }

  ngOnInit(): void {
    this.searchForm = new FormGroup({
      registrationNo: new FormControl('',
        [
          Validators.required,
          Validators.pattern("^[A-Z]{2} [0-9]{2} [A-Z]{1,2} [0-9]{4}$")
        ])
    });
  }

  async searchDetails() {
    console.log("searching details....")
    this.registrationNo = this.searchForm.value.registrationNo;
    let fetchedData = await this.regService.findByRegId(this.registrationNo);
    if (fetchedData) { 
      console.log("fetchedData : " , fetchedData);
      this.registration = fetchedData;
      console.log("Registration : ", this.registration);
      this.vehicle = fetchedData.vehicle;
      this.owner = fetchedData.owner;

    } else {
      this.registration = undefined; // No data found
      alert("No registration details found..!")
    }

    console.log(this.vehicle);
    console.log(this.owner);

  }
}
