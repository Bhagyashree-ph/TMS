import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CopModule } from './cop/cop.module';
import { RaiseOffenseComponent } from './cop/raise-offense/raise-offense.component';
import { CopHomeComponent } from './cop/cop-home/cop-home.component';
import { ClearOffenseComponent } from './cop/clear-offense/clear-offense.component';
import { ViewOffensesComponent } from './cop/view-offenses/view-offenses.component';
import { VehOwnDetailsComponent } from './cop/veh-own-details/veh-own-details.component';
import { LoginComponent } from './login/login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { TransferComponent } from './rto/transfer/transfer.component';


const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'cophome', component: CopHomeComponent},
  {path: 'raise', component: RaiseOffenseComponent},
  {path: 'clear', component: ClearOffenseComponent},
  {path: 'view', component: ViewOffensesComponent},
  {path: 'vehown', component: VehOwnDetailsComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'transfer', component: TransferComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
 
