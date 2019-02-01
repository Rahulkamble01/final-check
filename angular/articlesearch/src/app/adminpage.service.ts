import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions={
  headers: new HttpHeaders({
    'Content-Type':'application/json',
  })
}

@Injectable({
  providedIn: 'root'
})
export class AdminpageService {
  userData:any;
  url: string = "/articlesearch/getAnaylist/";
   blockUrl: string = "/articlesearch/anaylist/blocked"; 

  constructor(private http: HttpClient, ) { }

  search(email): Observable<any>{    
    console.log(email);
    return this.http.get<any>(this.url+email);
}

status(userData): Observable<any>{    
  console.log(userData);
  return this.http.post<any>(this.blockUrl,userData,httpOptions);
  } 
}
