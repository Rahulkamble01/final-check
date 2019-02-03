import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { DebugElement } from '@angular/core';
import { LoginComponent } from './login.component';
import { By, BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginService } from '../login.service';
import { HttpClientModule } from '@angular/common/http';
import { Routes } from '@angular/router';
import { SignupComponent } from '../signup/signup.component';
import { NewsapiComponent } from '../newsapi/newsapi.component';
import { AdminpageComponent } from '../adminpage/adminpage.component';
import { FavouriteComponent } from '../favourite/favourite.component';
import { RouterTestingModule } from '@angular/router/testing';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let de : DebugElement;
  let el : HTMLElement;

  beforeEach(async(() => {
    const routes: Routes = [
      { path : "", component: LoginComponent},
      { path : "login", component: LoginComponent},
      { path : "signup", component: SignupComponent},
     ];
    TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports : [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        RouterTestingModule
  ],
  providers : [
    { provide : LoginService }
  ]
    })
    .compileComponents().then(() =>{
      fixture = TestBed.createComponent(LoginComponent);
      component = fixture.componentInstance;

      de = fixture.debugElement.query(By.css('form'));
      el = de.nativeElement;

    });
  }));

  
  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('form should valid when field is not empty',async(()=> {
    //accessing controls
    component.form.controls['email'].setValue('Rahulkamble01@gmail.com');
    component.form.controls['password'].setValue('Rahulkamble01');
    expect(component.form.valid).toBeTruthy();
  }));
  it('form should invalid when empty',async(()=> {
    //accessing controls
    component.form.controls['email'].setValue('');
    component.form.controls['password'].setValue('');
    expect(component.form.valid).toBeFalsy();
  }));

  it('form invalid when email pattern is wrong ',async(()=>{
    component.form.controls['email'].setValue('Rahul');
    expect(component.form.valid).toBeFalsy();
    expect(component.form.controls['email'].valid).toBeFalsy();
  }));

  it('form invalid when password character less than 6',async(()=>{
    component.form.controls['password'].setValue('Rahul');
    expect(component.form.valid).toBeFalsy();
    expect(component.form.controls['password'].valid).toBeFalsy();
  }));
  
  it('is form invalid when password character more than 50',async(()=>{
    component.form.controls['password'].setValue('RahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulsdfsadfsafdsffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff');
    expect(component.form.valid).toBeFalsy();
    expect(component.form.controls['password'].valid).toBeFalsy();
  })); 

  it('should call the login method', async(()=> {
    fixture.detectChanges();
    spyOn(component, 'login');
    el =fixture.debugElement.query(By.css('button')).nativeElement;
    el.click();
    expect(component.login).toHaveBeenCalledTimes(1);
  }));


});


