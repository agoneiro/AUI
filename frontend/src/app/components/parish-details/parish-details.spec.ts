import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParishDetailsComponent } from './parish-details.component';

describe('ParishDetailsComponent', () => {
  let component: ParishDetailsComponent;
  let fixture: ComponentFixture<ParishDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ParishDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ParishDetailsComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
