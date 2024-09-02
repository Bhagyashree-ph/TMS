import { Component, OnInit } from '@angular/core';
import { AppRoutingModule } from '../app-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { User } from '../user';
import { SharedService } from '../shared/shared.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  userProfilePicture = 'https://example.com/default-profile-picture.jpg';
  currUser: User;
  avatarName: string[] = [];

  constructor(private sharedServiceRef: SharedService) { }

  ngOnInit(): void {
    this.currUser = this.sharedServiceRef.getUser();
    console.log(this.currUser,"Current user..!");
    this.avatarName = this.currUser.userName.split(' ');
    console.log(this.avatarName);
    if(this.avatarName.length == 1)
      this.avatarName.push(' ');
  }

}

