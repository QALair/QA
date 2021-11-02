package support;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshot {
    public static void capture(WebDriver nChrome, String file){
        File screenshot = ((TakesScreenshot)nChrome).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File(file));
        } catch (Exception e) {
            System.out.println("There was a problem while taking the screenshot."+ e.getMessage());
        }
    }
}
