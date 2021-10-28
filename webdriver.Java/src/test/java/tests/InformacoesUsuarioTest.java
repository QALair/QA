package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InformacoesUsuarioTest {
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        // setting the chromedriver location
        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");
        // creating a new variable and actually opening chrome already
        WebDriver nChrome = new ChromeDriver();
        nChrome.manage().window().maximize();

        //opening my first page, using teacher's webpage
        nChrome.get("http://www.juliodelima.com.br/taskit");

        // click at the link that contains the text "sign in"
        // If it was smth that I was going to use a lot :
        //WebElement linkSignIn = nChrome.findElement(By.linkText("Sign in"));
        //linkSignIn.click();
        nChrome.findElement(By.linkText("Sign in")).click(); // he is teaching to use the text element to find, but I already knew about xpath

        // type the login
        WebElement formularioSignInBox = nChrome.findElement(By.id("signinbox"));
        formularioSignInBox.findElement(By.name("login")).sendKeys("joaotn");
        // type the password
        formularioSignInBox.findElement(By.name("password")).sendKeys("A123b$"); // some rando password, didnt know who access this db
        // sign in click
        nChrome.findElement(By.linkText("SIGN IN")).click();

        assertEquals(1, 1);
    }
}
