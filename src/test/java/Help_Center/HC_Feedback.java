package Help_Center;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HC_Feedback {

    public HC_Feedback(WebDriver driver) {PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//*[@class=\"qA4kooDpxWnZ6uxeCiw9\" and @href=\"#/knowledge/1000034592\"]")
    public WebElement ArticlePage;

    @FindBy(xpath = "//*[@class=\"liDMsVvwRI22CepAEJ2Q\"]")
    public WebElement Feedback_Content;

    @FindBy(xpath = "//*[@class=\"rAzsDlinH3yKNHAGVE4w\"]")
    public WebElement Generic_Feedback_Content;

    @FindBy(xpath = "//*[@class=\"D8ZcaizHg9T4FJ9l11f9\" and text()=\"Yes\"]")
    public WebElement Feedback_Yes;

    @FindBy(xpath = "//*[@class=\"D8ZcaizHg9T4FJ9l11f9\" and text()=\"No\"]")
    public WebElement Feedback_No;


    @FindBy(xpath = "//*[@class=\"ReactModal__Content ReactModal__Content--after-open\"]")
    public WebElement Feedback_Form_No;

    @FindBy(xpath = "//*[@class=\"N9r71vPOltglWwu68MhS\"]")
    public WebElement Feedback_ThankYou;

    @FindBy(xpath = "//*[text()=\"Answers were not clear\"]")
    public WebElement Overall_HC_Feedback;

    @FindBy(xpath = "//*[text()=\"Article is fine but I need additional help\"]")
    public WebElement Feedback_Option1;

    @FindBy(xpath = "//*[@class=\"WqNiDKT8Qjx0Ht60RZwq\"]")
    public WebElement Feedback_Submit_Button;

    public void Submit_Feedback_Yes (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        boolean HC_Feedback;
        boolean HC_FeedbackThankYou;

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"qA4kooDpxWnZ6uxeCiw9\" and @href=\"#/knowledge/1000034592\"]")));
        Thread.sleep(1000);
        ArticlePage.click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"D8ZcaizHg9T4FJ9l11f9\" and text()=\"Yes\"]")));
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Feedback_Yes);

        try
        {
            HC_Feedback = Feedback_Content.isDisplayed();
            HC_FeedbackThankYou = Feedback_ThankYou.isDisplayed();
        }
        catch (Exception e)
        {
            HC_Feedback = false;
            HC_FeedbackThankYou = false;
        }

        if (HC_Feedback)
        {

            System.out.println("**************************************");
            System.out.println("Check 1: Feedback Section is Available");
            System.out.println("Case 11: Passed");
            System.out.println("***************");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"D8ZcaizHg9T4FJ9l11f9\" and text()=\"Yes\"]")));
            Thread.sleep(1000);
            Feedback_Yes.click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"N9r71vPOltglWwu68MhS\"]")));
            Thread.sleep(1000);

            if (HC_FeedbackThankYou)
            {
                System.out.println("****************************************");
                System.out.println("Check 2: Feedback Submitted Successfully");
                System.out.println("Case 11: Passed");
                System.out.println("***************");
            }
            else
            {
                System.out.println("***********************************");
                System.out.println("Check 3: Feedback Submittion Failed");
                System.out.println("Case 11: Failed");
                System.out.println("***************");

                softAssert.assertFalse(true,"Feedback Submittion Failed");

            }

        }
        else
        {
            System.out.println("******************************************");
            System.out.println("Check 4: Feedback Section is not Available");
            System.out.println("Case 11: Failed");
            System.out.println("**************");

            softAssert.assertFalse(true,"Feedback Section is not Available");

        }

        driver.navigate().back();
        Thread.sleep(4000);

        softAssert.assertAll();

    }

    //========================================================================================================

    public void Generic_Feedback (WebDriver driver) throws InterruptedException
    {
        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        boolean Gen_HC_Feedback;

        try
        {
            Gen_HC_Feedback = Generic_Feedback_Content.isDisplayed();
        }
        catch (Exception e)
        {
            Gen_HC_Feedback = false;
        }

        if (Gen_HC_Feedback)
        {
            System.out.println("**********************************************");
            System.out.println("Check 1: Generic Feedback Section is Available");
            System.out.println("Case 12: Passed");
            System.out.println("***************");

            if (driver.findElement(By.xpath("//*[text()=\"Answers were not clear\"]")).isDisplayed())
            {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Answers were not clear\"]")));
                Thread.sleep(1000);
                //driver.findElement(By.xpath("//*[text()=\"Answers were not clear\"]")).click();
                Overall_HC_Feedback.click();

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"aKvm7IOvMy_qmuO1Oulw\"]")));
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@class=\"aKvm7IOvMy_qmuO1Oulw\"]")).click();

                System.out.println("****************************************");
                System.out.println("Check 2: Feedback Submitted Successfully");
                System.out.println("Case 12: Passed");
                System.out.println("***************");

                Thread.sleep(5000);
            }
            else
            {
                System.out.println("*******************************************");
                System.out.println("Check 3: Overall Feedback Submittion Failed");
                System.out.println("Case 12: Failed");
                System.out.println("***************");

                softAssert.assertFalse(true,"Overall Feedback Submittion Failed");
            }

        }
        else
        {
            System.out.println("**************************************************");
            System.out.println("Check 4: Generic Feedback Section is not Available");
            System.out.println("Case 12: Failed");
            System.out.println("***************");

            softAssert.assertFalse(true,"Generic Feedback Section is not Available");

        }

        softAssert.assertAll();

    }


        //========================================================================================================

    public void Submit_Feedback_No (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        boolean HC_Feedback;
        boolean HC_FeedbackForm_NO;
        boolean HC_FeedbackThankYou;

        driver.navigate().refresh();
        Thread.sleep(4000);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"qA4kooDpxWnZ6uxeCiw9\" and @href=\"#/knowledge/1000034592\"]")));
        Thread.sleep(1000);
        ArticlePage.click();
        Thread.sleep(2000);

        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Feedback_Yes);
        System.out.println("Scrolling Check");

        Feedback_No.click();
        Thread.sleep(5000);



    }
}
