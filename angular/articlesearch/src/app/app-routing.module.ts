import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { NewsapiComponent } from './newsapi/newsapi.component';
import { AdminpageComponent } from './adminpage/adminpage.component';
import { FavouriteComponent } from './favourite/favourite.component';

const routes: Routes = [
  { path : "", component: LoginComponent},
  { path : "login", component: LoginComponent},
  { path : "signup", component: SignupComponent},
  { path : "news", component: NewsapiComponent},
  { path : "admin", component : AdminpageComponent},
  { path : "favourite", component : FavouriteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
