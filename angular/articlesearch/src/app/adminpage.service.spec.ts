import { TestBed } from '@angular/core/testing';

import { AdminpageService } from './adminpage.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('AdminpageService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [
      HttpClientTestingModule,
    ],
    providers: [
      AdminpageService
    ],
  }));

  it('should be created', () => {
    const service: AdminpageService = TestBed.get(AdminpageService);
    expect(service).toBeTruthy();
  });
});
