import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions={
  headers: new HttpHeaders({
    'Content-Type':'application/json',
  })
}


@Injectable({
  providedIn: 'root'
})


export class LanguageService {
  url : string = '/articlesearch/signup/getlanguages';

  constructor(private http : HttpClient) { }

  language():Observable<any>{
   
    return this.http.get<any>(this.url);
  }
}
