import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders  } from '@angular/common/http';
import { Observable } from 'rxjs';


const httpOptions={
  headers: new HttpHeaders({
    'Content-Type':'application/json',
  })
}

@Injectable({
  providedIn: 'root'
})
export class NewsapiService {
  languageCode:any;
  api_key = 'ff52b1888d2c41bcb4c1942098bfa767';

  url : string = '/articlesearch/article/saveArticle';
 
  constructor(private http:HttpClient) { }

  /* initSources(){
     return this.http.get('https://newsapi.org/v2/sources?language=en&apiKey='+this.api_key);
  }
  initArticles(){
   return this.http.get('https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey='+this.api_key);
  }
  getArticlesByID(source: String){
   return this.http.get('https://newsapi.org/v2/top-headlines?sources='+source+'&apiKey='+this.api_key);
  } */

  getArticles(languageCode): Observable<any> {
    let newsUrl: string = "https://newsapi.org/v2/top-headlines?language=" + languageCode + "&apiKey=" + this.api_key;
    return this.http.get(newsUrl);
  }

  saveArticles(title): Observable<any>{
    console.log("inside the newsservice to save article");
    console.log(title);
    return this.http.post<any>(this.url, title, httpOptions);
  }
}
