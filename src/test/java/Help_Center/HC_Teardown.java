package Help_Center;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HC_Teardown {

    public HC_Teardown(WebDriver driver) {
        HC_Wait.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void browserclose (WebDriver driver) throws InterruptedException
    {
        driver.close();
        driver.quit();
    }
}
