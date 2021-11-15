package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage{

    public LoginFormPage(WebDriver nChrome) {
        super(nChrome);
    }

    public LoginFormPage typeLogin(String login){
        nChrome.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
        return this;
    }

    public LoginFormPage typePassword(String password){
        nChrome.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
        return this;
    }

    public SecretPage clickSignIn(){
        nChrome.findElement(By.linkText("SIGN IN")).click();
        return new SecretPage(nChrome);
    }

    public SecretPage doLogin(String login, String password){
        typeLogin(login);
        typePassword(password);
        clickSignIn();

        return new SecretPage(nChrome);
    }
}
