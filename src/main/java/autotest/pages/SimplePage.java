package autotest.pages;

import autotest.steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by admin on 21.10.2017.
 */
public class SimplePage extends BasePage {

    public Object pageByName;
    public WebElement simpleElementFromPage;


    public SimplePage(String pageName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        String strPN = "autotest.pages."+pageName;
        pageByName =(BasePage) Class.forName(strPN).newInstance();

        PageFactory.initElements(BaseSteps.getDriver(), this);
    }


    public WebElement getSimpleElement(String elementName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        simpleElementFromPage = (WebElement) pageByName.getClass().getField(elementName).get(pageByName);
        return simpleElementFromPage;
    }




//////////////Elements


}
