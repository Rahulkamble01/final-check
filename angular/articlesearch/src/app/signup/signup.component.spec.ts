import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupComponent } from './signup.component';
import { DebugElement } from '@angular/core';
import { NewsapiComponent } from '../newsapi/newsapi.component';
import { By, BrowserModule } from '@angular/platform-browser';
import { SignupService } from '../signup.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';

describe('SignupComponent', () => {
  let component: SignupComponent;
  let fixture: ComponentFixture<SignupComponent>;
  let de : DebugElement;
  let el : HTMLElement;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SignupComponent],
      imports : [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        RouterTestingModule
  ],
  providers : [
    { provide : SignupService }
  ]
    })
    .compileComponents().then(() =>{
      fixture = TestBed.createComponent(SignupComponent);
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
    component.form.controls['name'].setValue('Rahulkamble');
    component.form.controls['password'].setValue('Rahulkamble01');
    /* component.form.controls['id'].setValue('1'); */
    expect(component.form.valid).toBeTruthy();
  }));

  it('form should invalid when field is empty',async(()=> {
    //accessing controls
    component.form.controls['email'].setValue('');
    component.form.controls['name'].setValue('');
    component.form.controls['password'].setValue('');
    /* component.form.controls['id'].setValue('1'); */
    expect(component.form.valid).toBeFalsy();
  }));

  it('is form invalid when email pattern is wrong ',async(()=>{
    component.form.controls['email'].setValue('Rahulk');
    expect(component.form.valid).toBeFalsy();
    expect(component.form.controls['email'].valid).toBeFalsy();
  }));

  it('is form invalid when password character less than 6',async(()=>{
    component.form.controls['password'].setValue('Rahul');
    expect(component.form.valid).toBeFalsy();
    expect(component.form.controls['password'].valid).toBeFalsy();
  }));
  
  it('is form invalid when password character more than 50',async(()=>{
    component.form.controls['password'].setValue('RahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulsdfsadfsafdsffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff');
    expect(component.form.valid).toBeFalsy();
    expect(component.form.controls['password'].valid).toBeFalsy();
  }));

  it('is form invalid when name character less than 6',async(()=>{
    component.form.controls['name'].setValue('Rahul');
    expect(component.form.valid).toBeFalsy();
    expect(component.form.controls['name'].valid).toBeFalsy();
  }));
  
  it('is form invalid when name character more than 50',async(()=>{
    component.form.controls['name'].setValue('RahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahuRAHULlklklklklkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkklRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulsdfsadfsafdsffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff');
    expect(component.form.valid).toBeFalsy();
    expect(component.form.controls['name'].valid).toBeFalsy();
  })); 

 /*  it('should call the signup method', async(()=> {
    fixture.detectChanges();
    spyOn(component, 'signup');
    el =fixture.debugElement.query(By.css('button')).nativeElement;
    el.click();
    expect(component.signup).toHaveBeenCalledTimes(1);
  })); */




});
