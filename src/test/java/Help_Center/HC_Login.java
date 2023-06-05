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
import java.util.Base64;
import java.util.List;
import java.util.Objects;

public class HC_Login {
    public HC_Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@data-meta=\"Field\" and @type=\"text\"]")
    public WebElement UserName;

    @FindBy(xpath = "//*[@data-meta=\"Field\" and @type=\"password\"]")
    public WebElement Password;

    @FindBy(xpath = "//*[@data-spm=\"dlogin\" and @class=\"mod-button\"]")
    public WebElement LoginButton;


    //head//title
    @FindBy(xpath = "//head//title")
    public WebElement PageTitle;


    static String decodedusername( String username)
    {
        byte[] decodedpassword = Base64.getDecoder().decode(username);
        return (new String(decodedpassword));
    }

    static String decodedpassword( String password)
    {
        byte[] decodedpassword = Base64.getDecoder().decode(password);
        return (new String(decodedpassword));
    }


    public void SelfServiceTool (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


        try {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-meta=\"Field\" and @type=\"text\"]")));
        Thread.sleep(1000);
        UserName.sendKeys(decodedusername("YWxpLmxhZGhhbmlAZGFyYXouY29t"));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-meta=\"Field\" and @type=\"password\"]")));
        Thread.sleep(1000);
        Password.sendKeys(decodedpassword("bWFuZ28xMjQ="));

        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-spm=\"dlogin\" and @class=\"mod-button\"]")));
        LoginButton.click();
        Thread.sleep(5000);


            System.out.println("****************************************");
            System.out.println("Check 1: Login to Help Center Successful");
            System.out.println("Case 1: Passed");
            System.out.println("**************");


        }
        catch (Exception e)
        {
            System.out.println("************************************");
            System.out.println("Check 1: Login to Help Center Failed");
            System.out.println("Case 2: Failed");
            System.out.println("**************");

            softAssert.assertFalse(true,"Login to Help Center Failed");

        }



        driver.navigate().to("https://m-helpcenter.daraz.pk/web/home.htm?hybrid=1");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"RZmrh1mZ_GKSl2fKJyQn\"]")));


/*
            WebElement MyOrders = driver.findElement(By.xpath("//*[@id=\"page-title\" and text()=\"My Orders\"]"));
            WebElement MyReturns = driver.findElement(By.xpath("//*[@id=\"page-title\" and text()=\"My Returns\"]"));


            if ( MyOrders.getText() == "My Orders")
            {
                System.out.println("**************************************");
                System.out.println("Check 1: SST My Orders Page is Working");
                System.out.println("Case 8: Passed");
                System.out.println("**************");

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"svg-icon\"]")));
                Back_to_HC.click();
                Thread.sleep(1500);

            }
            else if (MyReturns.getText()== "My Returns")
            {
                System.out.println("***************************************");
                System.out.println("Check 1: SST My Returns Page is Working");
                System.out.println("Case 8: Passed");
                System.out.println("**************");

                driver.navigate().back();
                Thread.sleep(1500);
            }

            else if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"page-title\" and text()=\"My Cancellations\"]"))).getText()== "My Cancellations")
            {
                System.out.println("********************************************");
                System.out.println("Check 1: SST My Cancellation Page is Working");
                System.out.println("Case 8: Passed");
                System.out.println("**************");

                driver.navigate().back();
                Thread.sleep(1500);
            }

             */
        softAssert.assertAll();

    }

}


