import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RaiseOffenseComponent } from './raise-offense.component';

describe('RaiseOffenseComponent', () => {
  let component: RaiseOffenseComponent;
  let fixture: ComponentFixture<RaiseOffenseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RaiseOffenseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RaiseOffenseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
