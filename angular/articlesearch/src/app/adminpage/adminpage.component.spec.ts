import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminpageComponent } from './adminpage.component';
import { DebugElement } from '@angular/core';
import { BrowserModule, By } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { AdminpageService } from '../adminpage.service';

describe('AdminpageComponent', () => {
  let component: AdminpageComponent;
  let fixture: ComponentFixture<AdminpageComponent>;
  let de : DebugElement;
  let el : HTMLElement;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminpageComponent ],
      imports : [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        RouterTestingModule
  ],
  providers : [
    { provide : AdminpageService }
  ]
    })
    .compileComponents().then(() =>{
      fixture = TestBed.createComponent(AdminpageComponent);
      component = fixture.componentInstance;

      /* de = fixture.debugElement.query(By.css('form'));
      
      el = de.nativeElement; */

    });
  }));


  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call the  get method', async(()=> {
    fixture.detectChanges();
    spyOn(component, 'get');
    el =fixture.debugElement.query(By.css('button')).nativeElement;
    el.click();
    expect(component.get).toHaveBeenCalledTimes(1);
  }));

});
