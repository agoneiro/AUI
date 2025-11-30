import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PriestForm } from './priest-form';

describe('PriestForm', () => {
  let component: PriestForm;
  let fixture: ComponentFixture<PriestForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PriestForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PriestForm);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
