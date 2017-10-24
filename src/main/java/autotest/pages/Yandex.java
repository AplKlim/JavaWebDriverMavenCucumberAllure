package autotest.pages;

import autotest.steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by admin on 20.10.2017.
 */
public class Yandex extends BasePage {

    public Yandex(){

        PageFactory.initElements(BaseSteps.getDriver(), this);

    }





//////////////Elements

    @FindBy(xpath = "//a[@data-id='market']")
    public WebElement market;






}
