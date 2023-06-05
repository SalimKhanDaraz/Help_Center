package Help_Center;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class HC_CategorySlider {

    public HC_CategorySlider(WebDriver driver) {PageFactory.initElements(driver, this);}

    @FindBy(xpath="//*[@class=\"nD30Dq6YZGFNhA_ZHEw6\" and @value=\"1000003924\"]")
    public WebElement Refund_Category;

    @FindBy(xpath="//*[@class=\"nD30Dq6YZGFNhA_ZHEw6\" and @value=\"1000001087\"]")
    public WebElement Payment_Category;

    @FindBy(xpath="//*[@class=\"nD30Dq6YZGFNhA_ZHEw6\" and @value=\"1000001075\"]")
    public WebElement Daraz_Category;

    public void CategorySlider (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        Actions actions = new Actions(driver);

        boolean slider;

        try
        {
             slider = Daraz_Category.isDisplayed();

        }
        catch (Exception e)
        {
            slider = false;
        }


        if (slider)
        {
            actions.dragAndDropBy(Daraz_Category, -200, 0).perform();
            Thread.sleep(1000);
            actions.dragAndDropBy(Daraz_Category, 200, 0).perform();

            System.out.println("***********************************");
            System.out.println("Check 1: Category Slider is working");
            System.out.println("Case 7: Passed");
            System.out.println("**************");

        }
        else
        {
            System.out.println("***************************************");
            System.out.println("Check 2: Category Slider is not working");
            System.out.println("Case 7: Failed");
            System.out.println("**************");

            softAssert.assertFalse(true,"Category Slider Failed");

        }

        softAssert.assertAll();

    }

}
