package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver nChrome;

    public BasePage(WebDriver nChrome){
        this.nChrome = nChrome;
    }

    public String captureToastText(){
        return nChrome.findElement(By.id("toast-container")).getText();
    }
}
