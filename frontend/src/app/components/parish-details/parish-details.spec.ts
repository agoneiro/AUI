import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParishDetails } from './parish-details';

describe('ParishDetails', () => {
  let component: ParishDetails;
  let fixture: ComponentFixture<ParishDetails>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ParishDetails]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ParishDetails);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
