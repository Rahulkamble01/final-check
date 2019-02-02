import { Component, OnInit } from '@angular/core';

import { FormGroup, FormControl, Validators, NgForm } from '@angular/forms';
import { SignupService } from '../signup.service';
import { LanguageService } from '../language.service';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  values :any;
  languageForm:any;
  languageNames: any;
  error: any;
  constructor(private service : SignupService, private languageService : LanguageService){}

  form = new FormGroup({
    email: new FormControl(
      '',
      [ Validators.required,
        Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$'),
        Validators.maxLength(255),
      ]),
    password: new FormControl(
      '',
      [ Validators.required,
        Validators.minLength(6),
        Validators.maxLength(50)]),

    name: new FormControl(
      '',
      [ Validators.required,
        Validators.minLength(6),
        Validators.maxLength(70),
      ]),
      language: new FormGroup({
        id: new FormControl('')
      })
  });

 
  ngOnInit() {
    console.log("inside the ngOnInit()")
    this.languageService.language().subscribe(
      data => {
      this.languageNames = data;
    
     })
  }

  /* https://code.tutsplus.com/tutorials/testing-components-in-angular-using-jasmine-part-2-services--cms-28933 -----? karma */

  signup(){
      //console.log(this.form.value)
      console.log("click on signup button");
      console.log(this.form);
      this.service.signup(this.form.value).subscribe(
        data =>{
         this.values=data;
         console.log("values "+this.values)
        },
        error =>{
          this.error = error;
        }
      )
      this.form.reset();
      
    }
  
}
