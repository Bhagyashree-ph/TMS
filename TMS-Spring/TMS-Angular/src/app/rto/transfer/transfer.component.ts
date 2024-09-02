import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { OffenseDetails } from 'src/app/cop/offenseDetails';
import { Owner } from 'src/app/cop/owner';
import { Registration } from 'src/app/cop/registration';
import { OffensesService } from 'src/app/cop/service/offenses.service';
import { RegistrationService } from 'src/app/cop/service/registration.service';
import { Vehicle } from 'src/app/cop/vehicle';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})

export class TransferComponent implements OnInit {

  searchOwner: FormGroup;
  transferForm: FormGroup;
  ownerDetails: Owner;
  vehicleDetails: Vehicle;
  isOffenseCleared: boolean = false;
  offenseData: Array<OffenseDetails> = null;
  newOwner: Owner;
  registration: Registration;
  headers = new HttpHeaders({

    'Content-Type': 'application/json'
  
  });

  constructor(private offdet: OffensesService, private regService: RegistrationService, private http: HttpClient) { }

  ngOnInit(): void {
    this.transferForm = new FormGroup({
      registrationId: new FormControl('', Validators.required)
    });
    this.searchOwner = new FormGroup({
      ownerId: new FormControl('', Validators.required)
    });

  }

  async searchDetails(registrationId: string){
    if(registrationId) {
      let fetchedData = await this.regService.findByRegId(registrationId);
      if (fetchedData) { 
        this.registration = fetchedData;
        console.log("fetchedData : " , fetchedData);
        this.vehicleDetails = fetchedData.vehicle;
        this.ownerDetails = fetchedData.owner;
  
      } else {
        this.registration = undefined; // No data found
        alert("No registration details found..!")
      }
      console.log('Going to fetch the offense details...');
      await this.fetchAllOffenses();
      console.log('Fetched offense data is : ', this.offenseData);
      
    }
  }
  async fetchAllOffenses() {
    let fetchedData = await this.offdet.findOffenseById(this.transferForm.value.registrationId);
    if (fetchedData) {
      const offenseArray = Array.isArray(fetchedData) ? fetchedData : [fetchedData];
      console.log("off array : ", offenseArray);
      const unpaidOffenses = offenseArray.filter((offense: OffenseDetails) => offense.penaltyStatus === ("unpaid"));
      this.offenseData = unpaidOffenses;
      console.log("off data", this.offenseData);
      
    } else {
      this.offenseData = undefined;
    }
    console.log(this.offenseData);
    
  }

  clearOffenses(){
    this.offenseData.forEach(offense => {
      offense.penaltyStatus = 'Paid';
      this.offdet.updateOffenses(offense);
    });
    this.isOffenseCleared = true;
  }

  async findOwner(ownerId: string){
    if(ownerId){
      await this.http.get('http://localhost:7070/TMS/tms/rto/getOwnerDetals?ownerId='+ownerId)
        .subscribe((data: Owner) => this.newOwner = data);
    } else{
      alert("Enter valid owner ID..!");
    }
  }

  async transferVehicle(){
    await this.http.put<any>('http://localhost:7070/TMS/tms/rto/transfer', {registrationEO: this.registration, ownerEO: this.newOwner}, {headers: this.headers})
        .subscribe( (fetchedReg: Registration) => {
            if(fetchedReg.owner.ownerId === this.ownerDetails.ownerId)
              alert("Vehicle transfered successfully..! \n New Owner is : " + fetchedReg.owner.ownerId);
        });
    this.ownerDetails = null;
    this.offenseData = null;
    this.vehicleDetails = null;
    this.newOwner = null;
    this.ngOnInit();
  }

}
