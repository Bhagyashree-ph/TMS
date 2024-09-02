import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VehOwnDetailsComponent } from './veh-own-details.component';

describe('VehOwnDetailsComponent', () => {
  let component: VehOwnDetailsComponent;
  let fixture: ComponentFixture<VehOwnDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VehOwnDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VehOwnDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
