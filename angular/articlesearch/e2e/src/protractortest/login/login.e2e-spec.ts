import { LoginPage } from './login.po';
import { protractor, browser } from 'protractor';
import { NewsapiPage } from '../newsapi/newsapi.po';

// import { ArticlePage } from '../article/article.po';
describe('Login page', () => {
    let page: LoginPage;
    let news = new NewsapiPage();
    // tslint:disable-next-line:label-position
   //  let article = new ArticlePage();
    const EC = protractor.ExpectedConditions;

    beforeEach(() => {
        page = new LoginPage();
        page.navigateToLoginPage();
    });


     it('should be able to login', () => {
        page.sendEmailForLogin().sendKeys('rahulkamble130595@gmail.com');
        page.sendPasswordForLogin().sendKeys('rahulkamble01@');
        page.getLoginButton().click();
        browser.wait(EC.visibilityOf(news.getTitle()));
    //    expect(article.getTitle().isPresent()).toBeTruthy();
        expect(browser.driver.getCurrentUrl()).toContain('/news');
    }); 

    /* it('should be not be able to login if email is wrong', () => {
        page.sendEmailForLogin().sendKeys('rahul@gmail.com');
        page.sendPasswordForLogin().sendKeys('123456');
        page.getLoginButton().click();
    }); */
});



// https://trailheadtechnology.com/ui-automation-testing-of-angular-apps-using-protractor-jasmine/
// https://scotch.io/@charlieoduk/angular-end-to-end-testing507


// --- Karma

// https://scotch.io/tutorials/testing-angular-with-jasmine-and-karma-part-1