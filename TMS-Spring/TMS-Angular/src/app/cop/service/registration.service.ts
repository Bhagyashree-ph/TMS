import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Registration } from '../registration';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  httpData: Registration;
  private url: string = "http://localhost:7070/TMS/tms";
  headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  async findByRegId(regNo: string): Promise<Registration> {
    console.log("Searching Registration details of :  ", regNo);
    let url = this.url+"/cop/getRegDetails?registrationNo="+regNo;
    console.log(url);
    const response = await this.http.get(url).toPromise();
    return response as Registration;
  }

}
