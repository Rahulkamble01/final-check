import { by, element} from 'protractor';

export class NewsapiPage{
    getTitle(){
        return element(by.css('h2'));
    }

    /* getFavouriteArticleButton(){
        return element(by.className('btn btn-primary'));
    } */
}