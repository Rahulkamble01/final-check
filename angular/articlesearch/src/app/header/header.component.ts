import { Component, OnInit } from '@angular/core';
import { NewsapiService } from '../newsapi.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isAdminLoggedIn: boolean = false;
  isAnyalistLoggedIn: boolean = false;
  loggedIn: boolean = false;

  constructor(private service: AuthService) { }

  ngOnInit() {

  }




}
