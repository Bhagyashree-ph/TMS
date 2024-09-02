import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { OffenseDetails } from '../offenseDetails';
import { OffensesService } from '../service/offenses.service';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-view-offenses',
  templateUrl: './view-offenses.component.html',
  styleUrls: ['./view-offenses.component.css']
})
export class ViewOffensesComponent implements OnInit {

  registrationNo = '';
  viewOffense: FormGroup;
  offenseData: Array<OffenseDetails> = [];
  isLoading = false;
  errorMessage: string = '';
  dataSource = new MatTableDataSource(this.offenseData);

  constructor(private offdet: OffensesService) { }

  ngOnInit(): void {
    this.viewOffense = new FormGroup({
      registrationNo: new FormControl('',
        [
          Validators.required,
          Validators.pattern("^[A-Z]{2} [0-9]{2} [A-Z]{1,2} [0-9]{4}$")
        ])
    });
    this.fetchAllOffenses();
  }

  applyFilter(filterValue: string) {
    console.log("filtervalue : ", filterValue);
    this.dataSource.filterPredicate = (data: OffenseDetails) => {
      return data.offenseDetailId.toLowerCase().includes(filterValue.toLowerCase());
    };
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  async onSubmit() {
    this.isLoading = true;
    this.errorMessage = '';
    this.registrationNo = this.viewOffense.value.registrationNo;

    try {
      console.log("Reg no is ", (this.registrationNo))
      const fetchedData = await this.offdet.findOffenseById(this.registrationNo);

      if (fetchedData) {
        console.log("fetchedData : ", fetchedData);
        const offenseArray = Array.isArray(fetchedData) ? fetchedData : [fetchedData];
        console.log("off array : ", offenseArray);
        this.offenseData = offenseArray;
        this.dataSource.data = this.offenseData; // Update the data source
      } else {
        this.offenseData = undefined; // No data found
      }
    } catch (error) {
      this.errorMessage = 'Error fetching offenses: ' + error;
      console.log(error);

    } finally {
      this.isLoading = false;
    }
  }

  async fetchAllOffenses() {
    let fetchedData = await this.offdet.findAllOffenses();
    if (fetchedData) {
      const offenseArray = (Array.isArray(fetchedData) ? fetchedData : [fetchedData]) as Array<OffenseDetails>;
      console.log("off array : ", offenseArray);
      this.offenseData = offenseArray;
      this.dataSource.data = this.offenseData; // Update the data source
    } else {
      this.offenseData = undefined;
    }
  }

}