import { Component, OnInit } from '@angular/core';
import { FavouriteService } from '../favourite.service';
import { AuthService } from '../auth.service';


@Component({
  selector: 'app-favourite',
  templateUrl: './favourite.component.html',
  styleUrls: ['./favourite.component.css']
})
export class FavouriteComponent implements OnInit {

  favouriteArticle: any;
  title: any;

  constructor(private articleService: FavouriteService, private service: AuthService) { }
  email: any;
  ngOnInit() {
    console.log("inside favourite article")
    this.email = this.service.getEmaiId();
    console.log("inside fav ng email id" + this.email)
    this.articleService.getFevouriteAricles(this.email).subscribe(data => {
      this.favouriteArticle = data.article;
      console.log(this.favouriteArticle);
    })
  }

  deleteArticle(article){
    
    console.log("inside delete method of favourite");
    this.articleService.removeArticle(article).subscribe(data => {
    })
  }

}
