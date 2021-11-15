package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver nChrome) {
        super(nChrome);
    }

    public LoginFormPage clickSignIn(){
        nChrome.findElement(By.linkText("Sign in")).click();

        return new LoginFormPage(nChrome);
    }
}
