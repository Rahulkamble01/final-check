import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { FormGroup, FormControl, Validators,  } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { LanguageService } from '../language.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  values: any;
  error : any;


  form = new FormGroup({
    email: new FormControl(
      'rahulkamble130595@gmail.com',
      [ Validators.required,
        Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$'),
        Validators.maxLength(255),
      ]),
    password: new FormControl(
      '123456',
      [ Validators.required,
        Validators.minLength(6),
        Validators.maxLength(50)]),
  });

  constructor(private service : LoginService, private languageService : LanguageService,private auth : AuthService, private router: Router){ }

  ngOnInit() {
  }

  login(){
    //console.log(this.form.value)
    console.log("click on login button");
    console.log(this.form);
    this.service.userLogin(JSON.stringify(this.form.value)).subscribe(
      data =>{
        console.log("authenticate")
        console.log(data.authenticate); // check the authentication status
        if (data.authenticate) {
          console.log(data.authenticate);
          this.languageService.setLanguageCode(data.user.language.languageCode); //set the anylist language id
          console.log(data.user.language.languageCode);

          this.auth.setUser(data.user);
          this.auth.setEmailId(data.user.email);
          console.log(data.user);

          /* this.auth.setEmailId(data.user.email);  //set email id
          console.log(data.user.email); */

          this.router.navigate(['/news']);
        }
         if (data.admin) {
           
      this.router.navigate(['/admin']);
        }
      },
      error =>{
        this.error = error;
      }
    )
    this.form.reset();
    
  }
}
