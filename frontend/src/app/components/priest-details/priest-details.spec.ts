import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PriestDetailsComponent } from './priest-details.component';

describe('PriestDetailsComponent', () => {
  let component: PriestDetailsComponent;
  let fixture: ComponentFixture<PriestDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PriestDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PriestDetailsComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
