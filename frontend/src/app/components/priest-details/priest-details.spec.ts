import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PriestDetails } from './priest-details';

describe('PriestDetails', () => {
  let component: PriestDetails;
  let fixture: ComponentFixture<PriestDetails>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PriestDetails]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PriestDetails);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
