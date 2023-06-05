package Help_Center;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HC_TopQuestions {

    public HC_TopQuestions(WebDriver driver) {PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//*[@class=\"rTI0UWYujDp2FCyUeeqQ\"]")
    public WebElement TopCategory_Section;

    @FindBy(xpath = "")
    public WebElement Greeting_Content;

}
