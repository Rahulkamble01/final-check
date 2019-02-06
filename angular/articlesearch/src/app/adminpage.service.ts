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
  url: string = "/articlesearch/rest/getAnaylist/";
  url1 : string = "/articlesearch/rest/getUsers/"
   blockUrl: string = "/articlesearch/rest/anaylist/blocked"; 

  constructor(private http: HttpClient, ) { }

 /*  search(name): Observable<any>{    
    console.log(name);
    return this.http.get<any>(this.url+name);
} */

search(name): Observable<any>{    
  console.log(name);
  return this.http.get<any>(this.url1+name);
}

status(userData): Observable<any>{    
  console.log(userData);
  return this.http.post<any>(this.blockUrl,userData,httpOptions);
  } 
}
