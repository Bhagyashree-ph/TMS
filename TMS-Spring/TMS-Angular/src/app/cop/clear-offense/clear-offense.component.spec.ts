import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClearOffenseComponent } from './clear-offense.component';

describe('ClearOffenseComponent', () => {
  let component: ClearOffenseComponent;
  let fixture: ComponentFixture<ClearOffenseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClearOffenseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClearOffenseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
