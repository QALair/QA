package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddContactPage extends BasePage {

    public AddContactPage(WebDriver nChrome) {
        super(nChrome);
    }

    public AddContactPage selectContactType(String type){
        WebElement fieldType = nChrome.findElement(By.id("addmoredata")).findElement(By.name("type"));
        new Select(fieldType).selectByVisibleText(type);

        return this;
    }

    public AddContactPage typeContact(String contact){
        nChrome.findElement(By.id("addmoredata")).findElement(By.name("contact")).sendKeys(contact);

        return this;
    }

    public MePage clickSave(){
        nChrome.findElement(By.id("addmoredata")).findElement(By.linkText("SAVE")).click();

        return new MePage(nChrome);
    }

    public MePage addContact(String type, String contact){
        selectContactType(type);
        typeContact(contact);
        clickSave();

        return new MePage(nChrome);
    }
}
