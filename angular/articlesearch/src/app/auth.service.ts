import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  isAdminLoggedIn = false;
  isAnyalistLoggedIn = false;
  loggedIn = false;
  role: string;
  emailId: any;
  user:any;
  id : any;
  token :any;

  constructor() { }

  getUser() {
    return this.user;
  }

  setUser(user) {
    this.user = user;
  }

  getEmaiId() {
    return this.emailId;
  }

  setEmailId(emailId: any) {
    this.emailId = emailId;
  }

  getId() {
    return this.emailId;
  }

  setId(id: any) {
    this.id = id;
  }

  login() {
    console.log("Inside auth service login()");
    this.loggedIn = true;
  }

  logout() {
    console.log("Inside auth service logout()");
    this.loggedIn = false;
  }

  getToken() {
    return this.token;
  }

  setToken(token: string) {
    this.token = token;
  }
  setRole(role: string) {
    this.role = role;
  }
  getRole() {
    return this.role;
  }
}
