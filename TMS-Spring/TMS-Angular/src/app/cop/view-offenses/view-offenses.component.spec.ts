import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewOffensesComponent } from './view-offenses.component';

describe('ViewOffensesComponent', () => {
  let component: ViewOffensesComponent;
  let fixture: ComponentFixture<ViewOffensesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewOffensesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewOffensesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
