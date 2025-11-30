import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PriestFormComponent } from './priest-form.component';

describe('PriestFormComponent', () => {
  let component: PriestFormComponent;
  let fixture: ComponentFixture<PriestFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PriestFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PriestFormComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
