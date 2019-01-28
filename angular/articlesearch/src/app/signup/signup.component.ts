import { Component, OnInit } from '@angular/core';

import { FormGroup, FormControl, Validators, NgForm } from '@angular/forms';
import { SignupService } from '../signup.service';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  values :any;
  constructor(private service : SignupService){}

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
      ])
  });

  ngOnInit() {
  }

  CheckUser() {
      //console.log(this.form.value)
      console.log(this.form);
      this.service.signup(this.form.value).subscribe(
        data =>{
         this.values=data;
         console.log("values "+this.values)
        }
      )
      
    }
  
}
