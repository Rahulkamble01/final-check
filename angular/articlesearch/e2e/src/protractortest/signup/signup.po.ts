import { browser, by, element } from 'protractor';

export class SignupPage{

    navigatedToSignupPage(){
        return browser.get('/signup');
    }

    sendEmailForSignup(){
        return element(by.id('signupemail'));
    }
 
    sendPasswordForSignup(){
     return element(by.id('signuppassword'));
 }
 sendNameForLogin(){
    return element(by.id('signupname'));
}

sendLanguageForLogin(){
 return element(by.id('signuplanguage'));
}

getSignupButton(){
    return element(by.className('btn btn-primary'));
}

getSigupMessage(){
    return element(by.className('alert alert-success'));
}
}