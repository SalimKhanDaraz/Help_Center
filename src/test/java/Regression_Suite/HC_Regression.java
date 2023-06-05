package Regression_Suite;

import Help_Center.*;
import io.qameta.allure.Description;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static Help_Center.HC_Wait.driver;

public class HC_Regression {

    HC_Setup DB = new HC_Setup(driver);
    HC_Teardown DTD = new HC_Teardown(driver);

    @BeforeTest
    public void HC_Setup() throws InterruptedException
    {
        HC_Wait.driver = DB.driver();
    }

    @AfterTest
    public void HC_TearDown() throws InterruptedException
    {

        HC_Teardown HTD = new HC_Teardown(driver);
        HTD.browserclose(driver);

    }

    @Test (retryAnalyzer = HC_Retry.class, priority = 1)
    @Description("Access Help Center URL")
    public void HC_Ventures () throws InterruptedException, IOException
    {
        String Venture = HC_Ventures.Venture;

        HC_Ventures HCV = new HC_Ventures(driver);
        HCV.Ventures(driver);

    }

    @Test (retryAnalyzer = HC_Retry.class, priority = 2)
    public void HC_Login () throws InterruptedException, IOException
    {
        HC_Login HCL = new HC_Login(driver);
        HCL.SelfServiceTool(driver);

    }
    /*

    @Test (retryAnalyzer = HC_Retry.class, priority = 3)
    public void HC_SelfServiceSection () throws InterruptedException, IOException
    {

        HC_SelfService HCSS = new HC_SelfService(driver);
        HCSS.SelfServiceSection(driver);

    }

    @Test (retryAnalyzer = HC_Retry.class, priority = 4)
    public void HC_SelfServiceTool () throws InterruptedException, IOException
    {

        HC_SelfService HCSS = new HC_SelfService(driver);
        HCSS.SelfServiceTool(driver);

    }

    @Test (retryAnalyzer = HC_Retry.class, priority = 5)
    @Description("Access Help Center URL")
    public void HC_SearchCase_1 () throws InterruptedException, IOException
    {

        HC_Search HCS = new HC_Search(driver);
        HCS.SearchBoxTextVerification(driver);

    }

    @Test (retryAnalyzer = HC_Retry.class, priority = 6)
    public void HC_SearchCase_2 () throws InterruptedException, IOException
    {

        HC_Search HCS = new HC_Search(driver);
        HCS.SearchIconVerification(driver);

    }

    @Test (retryAnalyzer = HC_Retry.class, priority = 7)
    public void HC_SearchCase_3 () throws InterruptedException, IOException
    {

        HC_Search HCS = new HC_Search(driver);
        HCS.Search_NotFound(driver);

    }

    @Test (retryAnalyzer = HC_Retry.class, priority = 8)
    public void HC_SearchCase_4 () throws InterruptedException, IOException
    {

        HC_Search HCS = new HC_Search(driver);
        HCS.Search_RemoveIcon(driver);

    }

    @Test (retryAnalyzer = HC_Retry.class, priority = 9)
    public void HC_Greetings () throws InterruptedException, IOException
    {

        HC_Greetings HCG = new HC_Greetings(driver);
        HCG.Greetings(driver);

    }


    @Test (retryAnalyzer = HC_Retry.class, priority = 10,enabled = false)
    public void HC_Announcement () throws InterruptedException, IOException
    {

        HC_Announcement HCA = new HC_Announcement(driver);
        HCA.Announcements(driver);

    }

    @Test (retryAnalyzer = HC_Retry.class, priority = 11)
    public void HC_SelfService () throws InterruptedException, IOException
    {

        HC_SelfService HCSS = new HC_SelfService(driver);
        HCSS.SelfServiceSection(driver);

    }


    @Test (retryAnalyzer = HC_Retry.class, priority = 12)
    public void HC_SearchCase_5 () throws InterruptedException, IOException
    {

        HC_Search HCS = new HC_Search(driver);
        HCS.Search_Suggestions(driver);

    }

    @Test (retryAnalyzer = HC_Retry.class, priority = 13)
    public void HC_SearchCase_6 () throws InterruptedException, IOException
    {

        HC_Search HCS = new HC_Search(driver);
        HCS.Search_Suggestion(driver);

    }

    @Test (retryAnalyzer = HC_Retry.class, priority = 14)
    public void HC_CategorySlider () throws InterruptedException, IOException
    {

        HC_CategorySlider HCS = new HC_CategorySlider(driver);
        HCS.CategorySlider(driver);

    }



    @Test (retryAnalyzer = HC_Retry.class, priority = 15)
    public void HC_CategorySlide () throws InterruptedException, IOException
    {

        HC_CategorySlide HCS = new HC_CategorySlide(driver);
        HCS.CategorySlide(driver);

    }



    @Test (retryAnalyzer = HC_Retry.class, priority = 16)
    public void HC_Cat_Spot () throws InterruptedException, IOException
    {

        HC_CategorySpot HCCST = new HC_CategorySpot(driver);
        HCCST.CategorySlide(driver);

    }

 */

    @Test (priority = 17)
    public void HC_Feedback_1 () throws InterruptedException, IOException
    {

        HC_Feedback HCFD = new HC_Feedback(driver);
        HCFD.Submit_Feedback_Yes(driver);

    }

    @Test (priority = 17)
    public void HC_Feedback_2 () throws InterruptedException, IOException
    {

        HC_Feedback HCFD = new HC_Feedback(driver);
        HCFD.Generic_Feedback(driver);

    }

    @Test (priority = 18,enabled = true)
    public void HC_Feedback_3 () throws InterruptedException, IOException
    {

        HC_Feedback HCFD = new HC_Feedback(driver);
        HCFD.Submit_Feedback_No(driver);

    }

}
