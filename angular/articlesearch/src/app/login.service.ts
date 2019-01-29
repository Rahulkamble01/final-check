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
export class LoginService {
  url : string = '/articlesearch/login/user';

  constructor(private http : HttpClient) { }

  userLogin(user):Observable<any>{
    console.log(user);
    return this.http.post<any>(this.url, user, httpOptions);
  }
}
