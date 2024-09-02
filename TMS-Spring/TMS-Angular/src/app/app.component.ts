import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd, ActivatedRoute } from '@angular/router';
import { filter } from 'rxjs/operators';
 
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'TMS';
  showNavbar: boolean = true;
 
  constructor(private router: Router, private route: ActivatedRoute) {
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe((event: NavigationEnd) => {
      this.displayComp(event);
    });
  }

  displayComp(event){
    this.showNavbar = !event.urlAfterRedirects.includes('/login');
    console.log(this.showNavbar, 'ShowNavbar..');
  }
}
 