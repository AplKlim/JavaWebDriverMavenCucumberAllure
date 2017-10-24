package autotest.steps;
import autotest.pages.*;
import cucumber.api.java.ru.Когда;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static autotest.steps.BaseSteps.userHash;
import static autotest.steps.BaseSteps.getDriver;


/**
 * Created by admin on 20.10.2017.
 */
public class CommonSteps {

    @Когда("^нажали \"(.+)\" на странице \"(.+)\"$")
    public void clickONpage(String elementName, String pageName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        WebElement pageEl = new SimplePage(pageName).getSimpleElement(elementName);
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(false);", pageEl) ;
        BasePage.wait.until(ExpectedConditions.elementToBeClickable(pageEl));
        pageEl.click();
    }

    @Когда("^заполнили на странице \"(.+)\" поле \"(.+)\" значением \"(.+)\"$")
    public void fillPageField(String pageName, String elementName,  String someValue) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchFieldException {
        WebElement pageEl = new SimplePage(pageName).getSimpleElement(elementName);
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(false);", pageEl) ;
        BasePage.wait.until(ExpectedConditions.visibilityOf(pageEl));
        pageEl.clear();
        if (userHash.containsKey(someValue))
            pageEl.sendKeys((String)userHash.get(someValue));
        else pageEl.sendKeys(someValue);
    }

    @Когда("^перешли \"(.+)\"$")
    public void goToUrl(String url) {
        getDriver().get(url);
    }


    @Когда("ждем \"(.+)\" сек$")
    public void waitSec(int sek) throws InterruptedException {
            Thread.sleep(sek*1000);
    }

}


