package Help_Center;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class HC_Greetings {

    public HC_Greetings(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class=\"nhIZA2SM8Ej0xRmL4NSk\"]")
    public WebElement Greeting_Section;

    @FindBy(xpath = "//*[@class=\"iYyH_w8TTMkQ2IGAUKZe\"]")
    public WebElement Greeting_Content;

    public void Greetings (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        boolean Content1, Content2;
        Thread.sleep(2000);

        try
        {
            Content1 = Greeting_Section.isDisplayed();
            Content2 = Greeting_Content.isDisplayed();

        }
        catch (Exception e)
        {
            Content1 = false;
            Content2 = false;
        }

        if (Content1 && Content2)
        {
            System.out.println("****************************************");
            System.out.println("Check 1: Greeting Section and data found");
            System.out.println("Case 10: Passed");
            System.out.println("**************");

        }
        else
        {
            System.out.println("********************************************");
            System.out.println("Check 2: Greeting Section and data not found");
            System.out.println("Case 10: Failed");
            System.out.println("**************");

            softAssert.assertFalse(true,"Greeting Section and data not found");

        }
        softAssert.assertAll();
    }
}
