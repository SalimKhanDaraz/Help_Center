package Help_Center;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class HC_CategorySliderSpot {

    public HC_CategorySliderSpot(WebDriver driver) {
        PageFactory.initElements(driver, this);}

    public void CategorySpot (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        List<WebElement> SliderSpot;
        List<WebElement> CategorySpot;

        for (int i = 0; i < 8; i++) {

            SliderSpot = driver.findElements(By.xpath("//*[@class=\"Ve1nldNCvVN1B5F6XLta\"]//div"));
            wait.until(ExpectedConditions.presenceOfElementLocated( By.xpath("//*[@class=\"Ve1nldNCvVN1B5F6XLta\"]//div")));

            Thread.sleep(2000);

           // SliderSpot.get(i).click();
            driver.findElements(By.xpath("//*[@class=\"Ve1nldNCvVN1B5F6XLta\"]//div")).get(i).click();
            Thread.sleep(5000);
            System.out.println(i +" click: "+driver.findElements(By.xpath("//*[@class=\"Ve1nldNCvVN1B5F6XLta\"]//div")).get(i).getText());

            Thread.sleep(2000);
            CategorySpot = driver.findElements(By.xpath("//*[@class=\"Ve1nldNCvVN1B5F6XLta\"]//div"));
            wait.until(ExpectedConditions.presenceOfElementLocated( By.xpath("//*[@class=\"Ve1nldNCvVN1B5F6XLta\"]//div")));
            //Thread.sleep(2000);
            CategorySpot.get(0).getText();
            System.out.println("         - 1st Spot: "+CategorySpot.get(0).getText());


            if ( driver.findElements(By.xpath("//*[@class=\"ZBHhIA_OT_1jo3YsnlG4\"]//a")).size()>=1){
                          if (Objects.equals(driver.findElements(By.xpath("//*[@class=\"Ve1nldNCvVN1B5F6XLta\"]//div")).get(i).getText(), CategorySpot.get(0).getText())){

                int size = driver.findElements(By.xpath("//*[@class=\"ZBHhIA_OT_1jo3YsnlG4\"]//a")).size();
                driver.findElements(By.xpath("//*[@class=\"ZBHhIA_OT_1jo3YsnlG4\"]//a"));
                System.out.println("         - L2 Categories are available" + " - " +size);
            }
            else
            {
                System.out.println(" L2 Categories not found");
                softAssert.assertFalse(true,"L2 Categories not found");
            }
        }

        }
        softAssert.assertAll();
    }
}
