package tests;

import static org.junit.Assert.*;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Generator;
import support.Screenshot;
import support.Web;

import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioTest_Data.csv")
public class UserInfoTest {
    private WebDriver nChrome;

    @Rule
    public TestName test = new TestName();

    @Test
    public void testLogin(){
        /* calling the setup from outside, this was made after refactoring   */
        nChrome = Web.createChrome();

        /* click at the link that contains the text "sign in" */
        nChrome.findElement(By.linkText("Sign in")).click(); // he is teaching to use the text element to find, but I already knew about xpath

        /* type the login */
        WebElement formularioSignInBox = nChrome.findElement(By.id("signinbox"));
        formularioSignInBox.findElement(By.name("login")).sendKeys("joaotn");
        /* type the password */
        formularioSignInBox.findElement(By.name("password")).sendKeys("A123b$"); // some rando password, didnt know who access this db
        /* sign in click */
        nChrome.findElement(By.linkText("SIGN IN")).click();

        /* identify that it is me who is logged by element */
        WebElement me = nChrome.findElement(By.className("me"));
        String textoNoElementoMe = me.getText();

        assertEquals( "Hi, joaotn", textoNoElementoMe);
        /* taking a screenshot after the assertion  */
        Screenshot.capture(nChrome,"D:\\test-report\\"+ test.getMethodName() + Generator.dataHoraParaArquivo()+".png");
    }
    // new test case, testing myself for doing smth alone, and it worked, java seems to be easy and cool
    @Test
    public void testMePanel(){
        /* Calling login method */
        testLogin();
        /* clicking at MEEE */
        nChrome.findElement(By.className("me")).click();
        /* Trying something that the teacher didnt teach yet, XPath!! */
        WebElement textoNoH4 = nChrome.findElement(By.xpath("/html/body/div[1]/div/div/h4"));
        /* doing the assertion comparing the h4, bcuz it is only on this page, and it worked */
        assertEquals("Hi, joaotn", textoNoH4.getText());
        /* taking a screenshot after the assertion  */
        Screenshot.capture(nChrome,"D:\\test-report\\"+ test.getMethodName() + Generator.dataHoraParaArquivo()+".png");
    }
    //ComboBoxes and Toast messages class
    @Test
    public void testAddMoreData(@Param(name="type")String type, @Param(name="contact")String contact, @Param(name="message")String expectedmessage){
        /* Calling login method again */
        testLogin();
        /* clicking at MEEE, I know, again, it is just to make it faster */
        nChrome.findElement(By.className("me")).click();
        /* click at the link that contains the text MORE DATA ABOUT YOU */
        nChrome.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        nChrome.findElement(By.xpath("//*[@id=\"moredata\"]/div[2]/button")).click();

        /* now the "add more data about me" panel is open, lets select the combo and add the data */
        WebElement popupAddMoreData = nChrome.findElement(By.id("addmoredata"));

        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(type);
        /* clicked on phone now its just add the data */

        popupAddMoreData.findElement(By.name("contact")).sendKeys(contact);
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        /* now the toast message */

        WebElement tMessage = nChrome.findElement(By.id("toast-container"));
        String message = tMessage.getText();

        assertEquals(expectedmessage, message);
        /* taking a screenshot after the assertion  */
        Screenshot.capture(nChrome,"D:\\test-report\\"+ test.getMethodName() + Generator.dataHoraParaArquivo()+".png");
    }
    /* removing information test */
    @Test
    public void removeAddInfo(){
        /* Im gonna call the login test */
        testLogin();
        nChrome.findElement(By.className("me")).click();
        nChrome.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
        nChrome.findElement(By.xpath("//span[text()=\"+5543991231234\"]/following-sibling::a")).click();

        /* Accepting the Json warning about the contact information removed */
        nChrome.switchTo().alert().accept();

        /* Now Im looking to the toast message warning me that the contact info was really removed */
        WebElement tMessage = nChrome.findElement(By.id("toast-container"));
        String message = tMessage.getText();

        /* Classic assertion about the removing confirmation */
        assertEquals("Rest in peace, dear phone!", message);

        /* taking a screenshot after the assertion  */
        Screenshot.capture(nChrome,"D:\\test-report\\"+ test.getMethodName() + Generator.dataHoraParaArquivo()+".png");

        /* waiting 10 seconds be4 the toast message disappear  */
        WebDriverWait cWait = new WebDriverWait(nChrome, 10);
        cWait.until(ExpectedConditions.stalenessOf(tMessage));
    }
    @After
    public void tearDown(){
        /* Classic logout added to finish every test case */
        nChrome.findElement(By.linkText("Logout")).click();
        /* closing the browser */
        nChrome.quit();
    }
}
