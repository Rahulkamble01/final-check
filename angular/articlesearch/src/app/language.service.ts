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

  languages:any;
  languageId:any;
  languageCode:any;

  getLanguage(){
    return  this.language;
   }

  setLanguages(languages:string){
    this.languages=languages;
 }
 
getLanguageId(){
  return  this.languageId;
 }

 setLanguageId(languageId:any){
     this.languageId=languageId;
  }

  getLanguageCode(){
    return  this.languageCode;
   }
  
   setLanguageCode(languageCode:string){
       this.languageCode=languageCode;
    }

  language():Observable<any>{
   
    return this.http.get<any>(this.url);
  }
}
