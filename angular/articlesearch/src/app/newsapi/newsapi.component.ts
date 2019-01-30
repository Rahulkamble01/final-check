import { Component, OnInit } from '@angular/core';
import { NewsapiService } from '../newsapi.service';
import { LanguageService } from '../language.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-newsapi',
  templateUrl: './newsapi.component.html',
  styleUrls: ['./newsapi.component.css']
})
export class NewsapiComponent implements OnInit {
  articlesList: any;
  languageCode: any;
  language: any;
  articles:any;
  //article:any;
  emailId:any;
  userData:any;
 

  /* mArticles:Array<any>;
  mSources:Array<any>; */
  constructor(private newsapi:NewsapiService, private languageService: LanguageService, private auth: AuthService) { }

  ngOnInit() {
    this.userData=this.auth.getUser();
    console.log(this.userData);
   /*  //load articles
    this.newsapi.initArticles().subscribe(data => this.mArticles = data['articles']);
    //load news sources
    this.newsapi.initSources().subscribe(data=> this.mSources = data['sources']); */
    //this.languageCode = this.languageService.getLanguageCode();
  
      this.languageCode="en";
    console.log(this.languageCode);
  
    this.newsapi.getArticles(this.languageCode).subscribe(
      data =>{
        this.articlesList  = data;
        console.log(this.articlesList);
      }
    )  

    /* const NewsAPI = require('newsapi');
    const newsapi = new NewsAPI('b6bfe2b91aa3400b9cc2bfe02a54bb08');
    // To query /v2/top-headlines
    // All options passed to topHeadlines are optional, but you need to include at least one of them
    newsapi.v2.topHeadlines({
      // sources: 'bbc-news',
      language: 'en',
      // sortBy: 'relevancy',
    }).then(response => {
      console.log(response); 
      this.articles = response.articles;
     
    });  */
  }
  


   saveFavourite(article){
    article['email'] = this.userData.email;
    console.log(article);
    this.newsapi.saveArticles(article).subscribe(
      data =>{
        console.log(data);
      
    })

  }
  
  } 

