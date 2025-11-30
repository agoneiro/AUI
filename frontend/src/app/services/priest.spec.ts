import { TestBed } from '@angular/core/testing';

import { PriestService } from './priest.service';

describe('Priest', () => {
  let service: PriestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PriestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
