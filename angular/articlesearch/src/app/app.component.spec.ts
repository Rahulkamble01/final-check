import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { NewsapiComponent } from './newsapi/newsapi.component';
import { AdminpageComponent } from './adminpage/adminpage.component';
import { FavouriteComponent } from './favourite/favourite.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { APP_BASE_HREF } from '@angular/common';
import { HeaderComponent } from './header/header.component';

describe('AppComponent', () => {

  const routes: Routes = [
    { path : "", component: LoginComponent},
    { path : "login", component: LoginComponent},
    { path : "signup", component: SignupComponent},
    { path : "news", component: NewsapiComponent},
    { path : "admin", component : AdminpageComponent},
    { path : "favourite", component : FavouriteComponent}
  ];
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        ReactiveFormsModule, 
        FormsModule, 
        AppRoutingModule, 
        RouterTestingModule
      ],
      declarations: [
        AppComponent,
        LoginComponent,
        SignupComponent,
        NewsapiComponent,
        AdminpageComponent,
        FavouriteComponent,
        HeaderComponent
      ],
      providers: [
        {provide : APP_BASE_HREF  , USE_VALUE:'/'}
      ]
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'articlesearch'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('articlesearch');
  });

});
