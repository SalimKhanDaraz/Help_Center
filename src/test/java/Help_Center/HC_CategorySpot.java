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

public class HC_CategorySpot {

    public HC_CategorySpot(WebDriver driver) {
    PageFactory.initElements(driver, this);}

    public void CategorySlide (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        List<WebElement> SliderSpot;
        List<WebElement> CategorySpot;

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()=\"Promotions\"]")).click();

        Thread.sleep(4000);

        for (int i = 0; i < 8; i++) {

            SliderSpot = driver.findElements(By.xpath("//*[@class=\"Ve1nldNCvVN1B5F6XLta\"]//div"));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"Ve1nldNCvVN1B5F6XLta\"]//div")));

           // System.out.println(i +" click: "+SliderSpot.get(i).getText());
            SliderSpot.get(i).click();
            Thread.sleep(3000);

            CategorySpot = driver.findElements(By.xpath("//*[@class=\"Ve1nldNCvVN1B5F6XLta\"]//div"));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"Ve1nldNCvVN1B5F6XLta\"]//div")));
            CategorySpot.get(0).getText();
            Thread.sleep(2000);
          //  System.out.println("         - 1st Spot: "+CategorySpot.get(0).getText());


            if (Objects.equals(SliderSpot.get(i).getText(), CategorySpot.get(0).getText()))
            {
                System.out.println("***********************************");
                System.out.println(i +" click: "+SliderSpot.get(i).getText());
                System.out.println("         - 1st Spot: "+CategorySpot.get(0).getText());

                System.out.println("Check 1: Category Slider is working");
                System.out.println("Case 10: Passed");
                System.out.println("**************");
            }
            else
            {
                System.out.println("***************************************");
                System.out.println("Check 2: Category Slider is not working");
                System.out.println("Case 10: Failed");
                System.out.println("**************");

                softAssert.assertFalse(true,"L2 Categories not found");
            }
        }
        softAssert.assertAll();
    }
}

