import { Injectable } from '@angular/core';
import { OffenseDetails } from '../offenseDetails';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class OffensesService {
 
  private url: string = "http://localhost:7070/TMS/tms";

  headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  addOffenses(offense: OffenseDetails): Promise<any> {
    console.log('Reporting an offense');
    return this.http.post("http://localhost:7070/TMS/tms/cop/raiseOffense", JSON.stringify(offense), {headers: this.headers})
      .toPromise();
  }
  

  async updateOffenses(offense: OffenseDetails) {
    console.log("Came to Update offense details:", offense);
  
    // Update penalty status only if it's currently "Unpaid"
    if (offense.penaltyStatus === 'unpaid') {
      offense.penaltyStatus = 'Paid';
      console.log("Updating offense details:", offense);
    }

    try {
      offense.img = "";
      console.log("Js : ", offense);
      let ofdDetail = JSON.stringify(offense);
      console.log("Json : ", ofdDetail);
      const putResponse = await this.http.put<any>(this.url+"/cop/clearOffenses", ofdDetail, {headers: this.headers})        
                                .subscribe(
                                  response => {
                                    console.log("Updated", response);
                                  },
                                  error => {
                                    console.error("Error updating the offense:", error);
                                  }
                                );
      console.log("Put response : ", putResponse);
      
    } catch (error) {
      console.error("Error updating offense details:", error);
      return null; // Indicate unsuccessful update
    }
  }
  
  

  findOffenseById(regNo: string): Promise<Array<OffenseDetails>> {
    console.log("Searching offenses commited by ", regNo);
    return new Promise((resolve) => {
      let url = this.url+"/cop/getAllOffensesOfRegNo?registrationNo="+regNo;
      console.log(url);
      
      this.http.get(url) 
        .subscribe((data: Array<OffenseDetails>) => {
          console.log("-----------------Data is : ", data);
          resolve(data); 
        })
    });
  }
  

  findAllOffenses(): Promise<Array<OffenseDetails>> {
    console.log("Fetching the offenses ");
    return new Promise((resolve) => {
      this.http.get(this.url+"/cop/getOffenses") 
        .subscribe((data: Array<OffenseDetails>) => {
          console.log("-----------------Data is : ", data);
          resolve(data); 
        })
    });
  } 
}
