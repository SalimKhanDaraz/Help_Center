package Help_Center;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class HC_SelfService {

    public HC_SelfService(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class=\"PfnCfr8E2C6EpBkx53mk\"]")
    public WebElement SelfServiceSection;

    @FindBy(xpath = "//*[@class=\"svg-icon\"]")
    public WebElement Back_to_HC;

    public void SelfServiceSection(WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        boolean Content1;
        Thread.sleep(2000);

        try {
            Content1 = SelfServiceSection.isDisplayed();

        } catch (Exception e) {
            Content1 = false;
        }

        if (Content1) {
            if (driver.findElements(By.xpath("//*[@class=\"f3bufdfZt8m80TRswkWT\"]")).size() >= 8) {
                System.out.println("***********************************");
                System.out.println("Check 1: SST Section and data found");
                System.out.println("Case 2: Passed");
                System.out.println("**************");
            } else {
                System.out.println("***************************************");
                System.out.println("Check 2: SST Section and data not found");
                System.out.println("Case 2: Failed");
                System.out.println("**************");

                softAssert.assertFalse(true, "SST Section and data not found");
            }
        }

        softAssert.assertAll();

    }

    //=====================================================================================================

    public void SelfServiceTool(WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        List<WebElement> SelfService_Tools;

        for (int i = 0; i < 8; i++) {

            try {
                SelfService_Tools = driver.findElements(By.xpath("//*[@class=\"f3bufdfZt8m80TRswkWT\"]"));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class=\"f3bufdfZt8m80TRswkWT\"]")));

                Thread.sleep(1500);
                System.out.println(i + " click: " + SelfService_Tools.get(i).getText());
                SelfService_Tools.get(i).click();
                Thread.sleep(1500);

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"svg-icon\"]")));
                Back_to_HC.click();

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"OUvoLIP67H31NKGPoSxx\"]")));
                Thread.sleep(1000);

                System.out.println("*************************************");
                System.out.println("Check 1 : SST Module Pages is Working");
                System.out.println("Case 3: Passed");
                System.out.println("**************");

            }
            catch (Exception e)
            {
                System.out.println("****************************************");
                System.out.println("Check 2: SST Module Pages is not Working");
                System.out.println("Case 3: Failed");
                System.out.println("**************");

                softAssert.assertFalse(true, "SST Module failed");

            }

        }

        softAssert.assertAll();
    }

}
