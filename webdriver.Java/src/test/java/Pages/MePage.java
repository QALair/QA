package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePage extends BasePage {
    public MePage(WebDriver nChrome){
        super(nChrome);
    }

    public MePage clickMoreDataAboutYou(){
        nChrome.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        return this;
    }

    public AddContactPage clickBtnAddMoreData(){
        nChrome.findElement(By.xpath("//*[@id=\"moredata\"]/div[2]/button")).click();

        return new AddContactPage(nChrome);
    }
}
