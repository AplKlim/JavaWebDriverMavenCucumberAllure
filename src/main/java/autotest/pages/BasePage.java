package autotest.pages;

import autotest.steps.BaseSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class BasePage  {

   //public static HashMap<String,Object> userHash = new HashMap<String,Object> ();



    public BasePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
    public static final Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(),90,2000);

}


