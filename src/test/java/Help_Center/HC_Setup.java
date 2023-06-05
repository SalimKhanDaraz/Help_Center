package Help_Center;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class HC_Setup {

    public HC_Setup(WebDriver driver) {

        // HC_Wait.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver driver() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/salim/Downloads/chromedriver");
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Galaxy S5");

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("headless");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        ChromeDriver driver = new ChromeDriver(options);
       // driver.get("https://m-helpcenter.daraz.pk/web/home.htm?hybrid=1");


        return driver;
    }
}
