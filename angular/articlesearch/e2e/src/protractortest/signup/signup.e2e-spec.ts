import { SignupPage } from "./signup.po";
import { LoginPage } from '../login/login.po';
import { protractor, browser } from 'protractor';

describe('Signup page', ()=>{
    let page : SignupPage;
    let login :LoginPage;

    const EC = protractor.ExpectedConditions;

    beforeEach(() => {
        page = new SignupPage();
        login = new LoginPage();
        page.navigatedToSignupPage();
    });

    it('should be able to signup', () => {
        page.sendEmailForSignup().sendKeys('rahulkamble1302595@gmail.com');
        page.sendPasswordForSignup().sendKeys('rahulkamble01@');
        page.sendNameForLogin().sendKeys('Sangamesh');
        page.sendLanguageForLogin().sendKeys('English');
        page.getSignupButton().click();
        browser.wait(EC.visibilityOf(page.getSigupMessage()));
       expect(page.getSigupMessage().getText()).toBe('Sign Up Successfull');
        expect(browser.driver.getCurrentUrl()).toContain('/signup');
    }); 

});