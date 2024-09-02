import { NgModule } from '@angular/core';
import { MatToolbarModule } from "@angular/material/toolbar";
import { MatTabsModule } from "@angular/material/tabs";
import {MatButtonModule} from '@angular/material/button';
import { MatButtonToggleModule } from "@angular/material/button-toggle";
import { MatIconModule } from "@angular/material/icon";
import { MatMenuModule } from "@angular/material/menu";
import { MatTooltipModule } from "@angular/material/tooltip";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatAutocompleteModule } from "@angular/material/autocomplete";
import { MatProgressSpinnerModule } from "@angular/material/progress-spinner";
import { MatTableModule } from "@angular/material/table";
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatCheckboxModule } from "@angular/material/checkbox";

const materialComponents = [
  MatToolbarModule, MatAutocompleteModule, MatTableModule,
  MatTabsModule, MatSnackBarModule, MatPaginatorModule,
  MatButtonModule,  MatButtonModule, MatCheckboxModule,
  MatButtonToggleModule,  MatInputModule,
  MatIconModule, MatFormFieldModule,
  MatMenuModule, MatCardModule,
  MatTooltipModule, MatProgressSpinnerModule,
  BrowserAnimationsModule
];

@NgModule({
  // declarations: [],
  imports: [
    // CommonModule
    materialComponents
  ],
  exports: [
    materialComponents
  ]
})
export class MaterialModule { }
