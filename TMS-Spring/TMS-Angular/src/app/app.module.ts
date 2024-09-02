import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CopModule } from './cop/cop.module';
import { HttpClientModule } from '@angular/common/http';
import { LoginModule } from './login/login.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
import { RtoModule } from './rto/rto.module';
import { ProfileComponent } from './profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    CopModule,
    FormsModule,
    HttpClientModule,
    LoginModule,
    BrowserAnimationsModule,
    MaterialModule,
    RtoModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
