package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {
    public static final String AUTOMATE_USERNAME = "notgonnasharemyCredentials";
    public static final String AUTOMATE_ACCESS_KEY = "notgonnasharemyCredentials";
    public static final String URLBROWSERSTACK = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "notgonnasharemyCredentials";

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

    public static WebDriver createBrowserStack(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("browserstack.local", "false");
        caps.setCapability("browserstack.selenium_version", "4.0.0");

        WebDriver nChrome = null;
        try {
            nChrome = new RemoteWebDriver(new URL(URLBROWSERSTACK), caps);
            nChrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            nChrome.get("http://www.juliodelima.com.br/taskit");
            nChrome.manage().window().maximize();
        }
        catch (MalformedURLException e){
            System.out.println("Houveram problemas com a URL: " + e.getMessage());
        }

        return nChrome;
    }

}
