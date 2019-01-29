import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { FormGroup, FormControl, Validators,  } from '@angular/forms';

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
  });

  constructor(private service : LoginService){ }

  ngOnInit() {
  }

  login(){
    //console.log(this.form.value)
    console.log("click on signup button");
    console.log(this.form);
    this.service.userLogin(this.form.value).subscribe(
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
