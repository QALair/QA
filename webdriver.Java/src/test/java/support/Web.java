package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver createChrome(){
        /* setting the chromedriver location */
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
        /* creating a new variable and actually opening chrome already */
        WebDriver nChrome = new ChromeDriver();
        nChrome.manage().window().maximize();
        nChrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        /* opening my first page, using teacher's webpage */
        nChrome.get("http://www.juliodelima.com.br/taskit");

        return nChrome;
    }

}
