import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParishFormComponent } from './parish-form.component';

describe('ParishFormComponent', () => {
  let component: ParishFormComponent;
  let fixture: ComponentFixture<ParishFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ParishFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ParishFormComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
