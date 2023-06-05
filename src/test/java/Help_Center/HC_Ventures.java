package Help_Center;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HC_Ventures {

    public static String Venture = "PK";

    public HC_Ventures(WebDriver driver) {
        PageFactory.initElements(driver, this);}

    public void Ventures (WebDriver driver) {


        switch (Venture) {
            case "PK":

               // driver.get("https://m-helpcenter.daraz.pk/web/home.htm?hybrid=1");
                driver.get("https://member-m.daraz.pk/user/login?spm=a2a0e.myaccount.0.0.10b93762bCZP1w");
                Allure.step("Launched PK Help Center Successfully");
                System.out.println("Launched PK HC Link");

                break;

            case "LK":

                driver.get("https://m-helpcenter.daraz.lk/web/home.htm?hybrid=1");
                Allure.step("Launched Daraz University LK Portal");

                break;

            case "NP":

                driver.get("https://m-helpcenter.daraz.com.np/web/home.htm?hybrid=1");
                Allure.step("Launched Daraz University NP Portal");

                break;

            case "BD":

                driver.get("https://m-helpcenter.daraz.com.bd/web/home.htm?hybrid=1");
                Allure.step("Launched Daraz University BD Portal");

                break;
        }

    }

}
