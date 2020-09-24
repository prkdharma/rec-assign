import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddcustomerCodedrivenComponent } from './addcustomer-codedriven.component';

describe('AddcustomerCodedrivenComponent', () => {
  let component: AddcustomerCodedrivenComponent;
  let fixture: ComponentFixture<AddcustomerCodedrivenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddcustomerCodedrivenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddcustomerCodedrivenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
