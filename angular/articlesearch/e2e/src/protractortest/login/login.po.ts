import { browser, by, element } from 'protractor';

export class LoginPage{

    getTitle(){
        return element(by.css('h2'));
    }
    
    navigateToLoginPage(){
        return browser.get('/login');
    }

   sendEmailForLogin(){
       return element(by.id('loginemail'));
   }

   sendPasswordForLogin(){
    return element(by.id('loginpassword'));
}

    getLoginButton(){
        return element(by.className('btn float-right login_btn'));
    }
}