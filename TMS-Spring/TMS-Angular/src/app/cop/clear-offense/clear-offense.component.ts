import { Component, NgZone, OnInit } from '@angular/core';
import { OffenseDetails } from '../offenseDetails';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { OffensesService } from '../service/offenses.service';
import { timer } from 'rxjs';
import { SelectionModel } from '@angular/cdk/collections';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-clear-offense',
  templateUrl: './clear-offense.component.html',
  styleUrls: ['./clear-offense.component.css']
})
export class ClearOffenseComponent implements OnInit {

  registrationNo: string = '';
  clearOffense: FormGroup;
  offenseData: OffenseDetails[] | undefined = [];
  isLoading: boolean;
  errorMessage: string = '';
  selectedOffenseIds: string[] = [];
  selection = new SelectionModel<OffenseDetails>(true, []);
  dataSource = new MatTableDataSource<OffenseDetails>(this.offenseData);

  constructor(private offdet: OffensesService, private ngZone: NgZone) { }

  ngOnInit(): void {
    console.log('Inside on init..')
    this.isLoading = false;
    this.clearOffense = new FormGroup({
      registrationNo: new FormControl('',
        [
          Validators.required,
          Validators.pattern("^[A-Z]{2} [0-9]{2} [A-Z]{1,2} [0-9]{4}$")
        ])
    });
    console.log('clearOffense form : ', this.clearOffense.status, this.clearOffense.value);

  }

  async onSubmit() {
    this.isLoading = true;
    this.errorMessage = '';
    this.selectedOffenseIds = [];
    this.registrationNo = this.clearOffense.value.registrationNo;

    timer(2000).subscribe(() => { // wait for 2 seconds
      this.getData();
    });
  }

  async getData() {
    try {
      console.log("Reg no is ", (this.registrationNo))
      const fetchedData = await this.offdet.findOffenseById(this.registrationNo);

      if (fetchedData.length > 0) {
        console.log("fetchedData : ", fetchedData);
        const offenseArray = Array.isArray(fetchedData) ? fetchedData : [fetchedData];
        console.log("off array : ", offenseArray);
        const unpaidOffenses = offenseArray.filter((offense: OffenseDetails) => offense.penaltyStatus === ("unpaid"));
        this.offenseData = unpaidOffenses;
      } else {
        this.offenseData = undefined; // No data found
        alert("No offense details found..");
      }
    } catch (error) {
      this.errorMessage = 'Error fetching offenses: ' + error;
      console.log(error);
    } finally {
      this.ngZone.run(() => {
        this.isLoading = false;
      });
    }
    console.log(this.isLoading);
  }


  masterToggle() {
    if (this.isAllSelected()) {
      this.selection.clear();
      this.selectedOffenseIds = [];
    } else {
      this.offenseData.forEach(offense => {
        this.selection.select(offense);
        this.selectedOffenseIds.push(offense.offenseDetailId);
      });
    }
    console.log("this.selectedOffenseIds.... : ", this.selectedOffenseIds);

  }

  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.offenseData.length;
    return numSelected === numRows;
  }

  toggleSelection(offense: OffenseDetails) {
    this.selection.toggle(offense);
    if (this.selection.isSelected(offense)) {
      this.selectedOffenseIds.push(offense.offenseDetailId);
    } else {
      const index = this.selectedOffenseIds.indexOf(offense.offenseDetailId);
      if (index !== -1) {
        this.selectedOffenseIds.splice(index, 1);
      }
    }
  }


  async clearSelected() {
    if (!this.selectedOffenseIds.length) {
      alert('Please select at least one offense to clear.');
      return;
    }
    console.log('Clearing penalty status for offenses:', this.selectedOffenseIds);

    this.offenseData.forEach(offense => {
      if (this.selectedOffenseIds.includes(offense.offenseDetailId)) {
        const updatedData = this.offdet.updateOffenses(offense);
        console.log("updatedData : ", updatedData);

        if (updatedData) {
          const offenseArray: Array<OffenseDetails> = (Array.isArray(updatedData) ? updatedData : [updatedData]) as Array<OffenseDetails>;
          offenseArray.forEach(off => {
            if (off.penaltyStatus === 'Paid')
              offense.penaltyStatus = 'Paid';
          });
        }
      }
    });

    // Filter out the selected rows from the offenseData array
    this.offenseData = this.offenseData.filter(offense => !this.selectedOffenseIds.includes(offense.offenseDetailId));

    // Clear the selected IDs array
    this.selectedOffenseIds = [];

    // Update the dataSource to reflect the changes
    this.dataSource.data = this.offenseData;
  }


}

