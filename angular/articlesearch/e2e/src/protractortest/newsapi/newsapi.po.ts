import { by, element} from 'protractor';

export class NewsapiPage{
    getTitle(){
        return element(by.css('h2'));
    }
}