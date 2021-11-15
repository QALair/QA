package tests;

import static org.junit.Assert.*;
import Pages.LoginPage;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import support.Web;



@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "infoData.csv")
public class UserInfoPageObjectsTest {
    private WebDriver nChrome;

    @Before
    public void setUp(){
        nChrome = Web.createBrowserStack();

    }

    @Test
    public void testAddUserAdditionalInfo(
            @Param(name = "login")String login,
            @Param(name = "password")String password,
            @Param(name = "cttType")String cttType,
            @Param(name = "contact")String contact,
            @Param(name = "expectedMsg")String expectedMsg){
        String toastText = new LoginPage(nChrome)
                .clickSignIn()
                .doLogin(login, password)
                .clickMePage()
                .clickMoreDataAboutYou()
                .clickBtnAddMoreData()
                .addContact(cttType, contact)
                .captureToastText();

        assertEquals(expectedMsg, toastText);
    }

    @After
    public void tearDown(){
        nChrome.quit();
    }

}
