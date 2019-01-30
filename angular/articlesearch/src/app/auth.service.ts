import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  isAdminLoggedIn = false;
  isLearnerLoggedIn = false;
  loggedIn = false;
  role: string;
  emailId: any;
  user:any;

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

  login() {
    console.log("Inside auth service login()");
    this.loggedIn = true;
  }

  logout() {
    console.log("Inside auth service logout()");
    this.loggedIn = false;
  }

  getRole() {
    return this.role;
  }

  setRole(role: string) {
    this.role = role;
  }
}
