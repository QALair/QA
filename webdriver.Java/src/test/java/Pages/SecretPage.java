package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecretPage extends BasePage {

    public SecretPage(WebDriver nChrome) {
        super(nChrome);
    }

    public MePage clickMePage(){
        nChrome.findElement(By.className("me")).click();

        return new MePage(nChrome);
    }
}
