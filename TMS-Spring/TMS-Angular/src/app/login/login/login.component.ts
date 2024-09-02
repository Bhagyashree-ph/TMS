import { HttpClient, HttpParams, HttpUrlEncodingCodec } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { SharedService } from 'src/app/shared/shared.service';
import { User } from 'src/app/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  httpData;
  passwordEntered = false;
  buttonHovered = false;

  constructor(
    private http: HttpClient,
    private router: Router,
    private sharedServiceRef: SharedService
  ) { }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
    });
  }

  async login() {
    let userId = this.loginForm.value.username;
    let url: string = 'http://localhost:7070/TMS/tms/login';
    const observable = await this.http.get(url + '?userId=' + userId);
    observable.subscribe(
      (data: any) => {
        this.validateUser(data);
      },
      (error: any) => {
        console.error(error);
        alert("no such user..!")
      },
      () => {
        console.log('Completed');
      }
    );
    console.log('Login button clicked!');
  }

  validateUser(user: User) {
    console.log("data is : ", user);
    let password = this.loginForm.value.password;

    if (user.password === password) {
      switch (user.role.roleName) {
        case 'Admin': this.router.navigate(['/adminhome']);
          break;
        case 'Cop': this.router.navigate(['/cophome']);
          this.sharedServiceRef.setUser(user);
          break;
        case 'Clerk': this.router.navigate(['/cophome']);
          this.sharedServiceRef.setUser(user);
          break;
        case 'RTO': this.router.navigate(['/rtohome']);
          break;
        default: alert('Invalid user.!');
          break;
      }
    }
    else
      alert("Wrong password..!");
  }

  passClicked(){
    this.passwordEntered = true;
  }

  buttonHover(){
    this.buttonHovered = true;
  }

}
