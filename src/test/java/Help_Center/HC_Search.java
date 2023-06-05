package Help_Center;

import io.qameta.allure.Allure;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Objects;

public class HC_Search {

    public HC_Search(WebDriver driver)
    {PageFactory.initElements(driver, this);}

    @FindBy(xpath="//*[@class=\"fZqLfjS1uHwYdkxLUb9m\"]")
    public WebElement SearchBar;

    @FindBy(xpath="//*[@class=\"mT74XE17a_Y30cZelZWi\"]")
    public WebElement SearchIcon;

    @FindBy(xpath="//*[@class=\"fZqLfjS1uHwYdkxLUb9m\"]")
    public WebElement SearchPlaceHolder;

    @FindBy(xpath="//*[@class=\"TWriiEPQIk1BNOfRAor_\"]")
    public WebElement NoResultFound;

    @FindBy(xpath="//*[@class=\"CahO15U7jfe0V_OJGYdV\"]")
    public WebElement CloseIcon;

    @FindBy(xpath="//*[text()=\"How can I avail Sticker Price?\"]")
    public WebElement SearchSuggestion;

    @FindBy(xpath="//*[@class=\"zOAodfFFSXYQxHntYUeh\"]")
    public WebElement SearchSuggestion_Article;

    //================================== Method 01 ===============================================

    public void SearchBoxTextVerification (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"fZqLfjS1uHwYdkxLUb9m\"]")));
        Thread.sleep(1500);
        String ActualSearchBoxText = SearchPlaceHolder.getAttribute("placeholder");
        String ExpectedSearchBoxText = "Search for questions, topics here";
        //System.out.println("Search Box Placeholder: " + ActualSearchBoxText);

        if (Objects.equals(ActualSearchBoxText, ExpectedSearchBoxText))
        {
            System.out.println("************************************");
            System.out.println("Check 1: Searchbox text is available");
            System.out.println("Case 4: Passed");
            System.out.println("**************");

        }
        else
        {
            System.out.println("************************************");
            System.out.println("Check 2: Searchbox text not matched");
            System.out.println("Case 4: Failed");
            System.out.println("**************");

            softAssert.assertFalse(true,"Searchbox text no matched");
        }

        softAssert.assertAll();
    }


    //================================== Method 02 ===============================================
    public void SearchIconVerification (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"mT74XE17a_Y30cZelZWi\"]")));
        Thread.sleep(1500);

        boolean Icon;

        try{
            Icon = SearchIcon.isDisplayed();
        }
        catch(Exception e)
        {
            Icon = false;
        }

        if (Icon)
        {
            System.out.println("*********************************");
            System.out.println("Check 1: Search Icon is available");
            Allure.step("Search Icon is available");
            System.out.println("Case 5: Passed");
            System.out.println("**************");
            Allure.step("Search Module Passed");
            System.out.println("");
        }
        else
        {
            System.out.println("");
            System.out.println("******************************");
            System.out.println("Check 2: Search Icon not found");
            Allure.step("Search Icon not found");
            System.out.println("Case 5: Search Module Failed");
            System.out.println("****************************");
            Allure.step("Search Icon not found");
            System.out.println("");

            softAssert.assertFalse(true,"Search Icon not found");
        }

        softAssert.assertAll();

    }

    //================================== Method 03 ===============================================

    public void Search_NotFound (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"fZqLfjS1uHwYdkxLUb9m\"]")));
        Thread.sleep(1000);
        SearchBar.sendKeys("vvvvv");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"TWriiEPQIk1BNOfRAor_\"]")));
        Thread.sleep(1500);

        boolean InvalidSearchResult;

        try{
            InvalidSearchResult = NoResultFound.isDisplayed();
        }
        catch(Exception e)
        {
            InvalidSearchResult = false;
        }

        if (InvalidSearchResult)
        {
            System.out.println("****************************");
            System.out.println("Check 1: Invalid Search Case");
            Allure.step("Search Icon is available");
            System.out.println("Case 6: Passed");
            System.out.println("**************");
            Allure.step("Search Module Passed");
            System.out.println("");
        }
        else
        {
            System.out.println("");
            System.out.println("****************************");
            System.out.println("Check 2: Invalid Search Case");
            Allure.step("Search Icon not found");
            System.out.println("Case 6: Search Module Failed");
            System.out.println("****************************");
            Allure.step("Search Icon not found");
            System.out.println("");

            softAssert.assertFalse(true,"Invalid Search Case");
        }

        softAssert.assertAll();

    }

    //================================== Method 04 ===============================================

    public void Search_RemoveIcon (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Actions act = new Actions(driver);

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"fZqLfjS1uHwYdkxLUb9m\"]")));
       // Thread.sleep(1000);
       // SearchBar.sendKeys("vvvvv");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"CahO15U7jfe0V_OJGYdV\"]")));
        Thread.sleep(1500);

        boolean RemoveIcon;

        try{
            RemoveIcon = CloseIcon.isDisplayed();
        }
        catch(Exception e)
        {
            RemoveIcon = false;
        }

        if (RemoveIcon)
        {
            System.out.println("************************");
            System.out.println("Check 1: Close Icon Case");
            Allure.step("Search Icon is available");
            System.out.println("Case 7: Passed");
            System.out.println("**************");
            Allure.step("Search Module Passed");
            System.out.println("");

            act.doubleClick(CloseIcon).perform();

        }
        else
        {
            System.out.println("");
            System.out.println("************************");
            System.out.println("Check 2: Close Icon Case");
            Allure.step("Search Icon not found");
            System.out.println("Case 7: Search Module Failed");
            System.out.println("****************************");
            Allure.step("Close Icon not found");
            System.out.println("");

            softAssert.assertFalse(true,"Close Icon Case failed");
        }

        softAssert.assertAll();

    }

    //================================== Method 05 ===============================================

    public void Search_Suggestions (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"fZqLfjS1uHwYdkxLUb9m\"]")));
        Thread.sleep(1000);
        SearchBar.sendKeys("price");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"HhKIOe7NwNv6pGPmHJyn\"]//a")));
        Thread.sleep(1500);
        int SearchSuggestionsCount =  driver.findElements(By.xpath("//*[@class=\"HhKIOe7NwNv6pGPmHJyn\"]//a")).size();
        //System.out.println(SearchSuggestionsCount);

        if (SearchSuggestionsCount==5)
        {
            System.out.println("*********************************");
            System.out.println("Check 1: Search Suggestions Count");
            Allure.step("Search Icon is available");
            System.out.println("Case 8: Passed");
            System.out.println("**************");
            Allure.step("Search Module Passed");
            System.out.println("");

        }
        else
        {
            System.out.println("");
            System.out.println("*********************************");
            System.out.println("Check 2: Search Suggestions Count");
            Allure.step("Search Icon not found");
            System.out.println("Case 8: Search Module Failed");
            System.out.println("****************************");
            Allure.step("Close Icon not found");
            System.out.println("");

            softAssert.assertFalse(true,"Search Suggestion Count Case failed");
        }

        softAssert.assertAll();

    }

    //================================== Method 06 ===============================================

    public void Search_Suggestion (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"How can I avail Sticker Price?\"]")));
        Thread.sleep(1000);
        SearchSuggestion.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"zOAodfFFSXYQxHntYUeh\"]")));
        Thread.sleep(1500);

        boolean ArticleTitle;

        try{
            ArticleTitle = SearchSuggestion_Article.isDisplayed();
        }
        catch(Exception e)
        {
            ArticleTitle = false;
        }

        if (ArticleTitle)
        {
            System.out.println("************************************************");
            System.out.println("Check 1: Article displayed via Search Suggestion");
            Allure.step("Search Icon is available");
            System.out.println("Case 9: Passed");
            System.out.println("**************");
            Allure.step("Search Module Passed");
            System.out.println("");

        }
        else
        {
            System.out.println("");
            System.out.println("****************************************************");
            System.out.println("Check 2: Article Not displayed via Search Suggestion");
            Allure.step("Search Icon not found");
            System.out.println("Case 9: Search Module Failed");
            System.out.println("****************************");
            Allure.step("Close Icon not found");
            System.out.println("");

            softAssert.assertFalse(true,"Search Suggestion Count Case failed");
        }

        softAssert.assertAll();
    }
}

