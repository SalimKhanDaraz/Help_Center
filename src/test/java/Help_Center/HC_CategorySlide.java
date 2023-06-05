package Help_Center;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class HC_CategorySlide {
    public HC_CategorySlide(WebDriver driver) {PageFactory.initElements(driver, this);}

    public void CategorySlide (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        List<WebElement> SliderSpot;

        for (int i = 0; i < 8; i++) {

            SliderSpot = driver.findElements(By.xpath("//*[@class=\"Ve1nldNCvVN1B5F6XLta\"]//div"));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"Ve1nldNCvVN1B5F6XLta\"]//div")));

            System.out.println(i + " click: " + SliderSpot.get(i).getText());
                SliderSpot.get(i).click();
                Thread.sleep(3000);

            if ( driver.findElements(By.xpath("//*[@class=\"ZBHhIA_OT_1jo3YsnlG4\"]//a")).size()>=1)
                {
                    int size = driver.findElements(By.xpath("//*[@class=\"ZBHhIA_OT_1jo3YsnlG4\"]//a")).size();
                    driver.findElements(By.xpath("//*[@class=\"ZBHhIA_OT_1jo3YsnlG4\"]//a"));
                    System.out.println("         - L2 Categories are available" + " - " +size);
                }
                else if (driver.findElement(By.xpath("//*[@class=\"E1gFNGVHKHPRNiayKK9C\"]")).isDisplayed())
                {
                    System.out.println(" L2 Categories not found");
                    softAssert.assertFalse(true,"L2 Categories not found");
                }
                else
                {
                    System.out.println(" L2 Categories not found");
                    softAssert.assertFalse(true,"L2 Categories not found");
                }
        }
        softAssert.assertAll();
    }
}
