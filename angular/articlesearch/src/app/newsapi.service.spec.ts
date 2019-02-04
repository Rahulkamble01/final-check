import { TestBed } from '@angular/core/testing';

import { NewsapiService } from './newsapi.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('NewsapiService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [
      HttpClientTestingModule,
    ],
    providers: [
      NewsapiService
    ],
  }));

  it('should be created', () => {
    const service: NewsapiService = TestBed.get(NewsapiService);
    expect(service).toBeTruthy();
  });
});
