package Help_Center;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.Objects;

public class HC_Announcement {

    public HC_Announcement(WebDriver driver) {PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//*[@class=\"V4v2vDQOLFLezsAGpf15\"]")
    public WebElement Announcement_Section;

    @FindBy(xpath = "//*[@class=\"j1ebxOWjKqttNP4NmfRG\"]")
    public WebElement Announcement_Content;

    @FindBy(xpath = "//*[@class=\"j1ebxOWjKqttNP4NmfRG\"]")
    public WebElement Announcement_Type;

    public void Announcements (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        Thread.sleep(2000);
        boolean AnnouncementSec, AnnouncementContent;

        String ExpectedAnnouncementType = Announcement_Type.getAttribute("style");
        String ActualAnnouncementType = "color: rgb(44, 127, 255);";
        System.out.println("Announcement Type: "+ExpectedAnnouncementType);

        try
        {
            AnnouncementSec = Announcement_Section.isDisplayed();
            AnnouncementContent = Announcement_Content.isDisplayed();

        }
        catch (Exception e)
        {
            AnnouncementSec = false;
            AnnouncementContent = false;
        }

        Thread.sleep(2000);

        if (AnnouncementSec && AnnouncementContent && Objects.equals(ExpectedAnnouncementType, ActualAnnouncementType)) {
            System.out.println("********************************************");
            System.out.println("Check 1: Announcement Section and data found");
            System.out.println("Check 2: Announcement Type is Info");
            System.out.println("Case 11: Passed");
            System.out.println("**************");

        }
        else
        {
            System.out.println("************************************************");
            System.out.println("Check 2: Announcement Section and data not found");
            System.out.println("Case 11: Failed");
            System.out.println("**************");

            softAssert.assertFalse(true,"Announcement Section and data not found");


        }
        softAssert.assertAll();
    }
}
