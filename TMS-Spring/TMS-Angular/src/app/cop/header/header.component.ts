import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SharedService } from 'src/app/shared/shared.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isDarkTheme: boolean = false;
  showVehOwn: boolean;

  constructor(
    private router: Router,
    private sharedServiceref: SharedService,
  ) { }

  ngOnInit(): void {
    this.showVehOwn = this.sharedServiceref.getUser().role.roleName === 'Cop' ? true : false;
    console.log(this.showVehOwn);

  }

  toggleTheme(): void {
    this.isDarkTheme = !this.isDarkTheme;
    if (this.isDarkTheme)
      document.body.classList.toggle('dark-theme');
    else
      document.body.classList.toggle('light-theme');
  }
}
