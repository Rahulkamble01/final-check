import { TestBed } from '@angular/core/testing';

import { FavouriteService } from './favourite.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';


describe('FavouriteService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [
      HttpClientTestingModule,
    ],
    providers: [
      FavouriteService
    ],
  }));

  it('should be created', () => {
    const service: FavouriteService = TestBed.get(FavouriteService);
    expect(service).toBeTruthy();
  });
});
