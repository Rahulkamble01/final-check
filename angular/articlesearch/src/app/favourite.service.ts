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
export class FavouriteService {

  url = "/articlesearch/getAnaylist/";

  constructor(private http : HttpClient) { }
  getFevouriteAricles(emailId):Observable<any>{ 
    console.log("inside the service");
    return this.http.get<any>(this.url+emailId);
}
}
