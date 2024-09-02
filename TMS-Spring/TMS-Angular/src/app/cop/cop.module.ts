import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CopHomeComponent } from './cop-home/cop-home.component';
import { RaiseOffenseComponent } from './raise-offense/raise-offense.component';
import { ClearOffenseComponent } from './clear-offense/clear-offense.component';
import { VehOwnDetailsComponent } from './veh-own-details/veh-own-details.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ViewOffensesComponent } from './view-offenses/view-offenses.component';
import { HeaderComponent } from './header/header.component';
import { MaterialModule } from '../material/material.module';
import { AppRoutingModule } from '../app-routing.module';


@NgModule({
  declarations: [
    RaiseOffenseComponent,
    ClearOffenseComponent,
    VehOwnDetailsComponent,
    ViewOffensesComponent,
    HeaderComponent,
    CopHomeComponent
  ], 
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    MaterialModule,
    AppRoutingModule 
  ], 
  exports: [
    RaiseOffenseComponent,
    ClearOffenseComponent,
    VehOwnDetailsComponent,
    ViewOffensesComponent,
    HeaderComponent,
    CopHomeComponent
  ]
})
export class CopModule { }
