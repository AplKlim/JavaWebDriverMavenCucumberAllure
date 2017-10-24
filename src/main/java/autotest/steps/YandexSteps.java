package autotest.steps;

import autotest.pages.BasePage;
import autotest.pages.*;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

import static autotest.steps.BaseSteps.getDriver;


/**
 * Created by admin on 22.10.2017.
 */
public class YandexSteps {


    @Когда("^выбрали в Яндекс-маркет категорию \"(.+)\" - \"(.+)\"$")
    public void selectMarketCategory(String cat, String subCat) throws InterruptedException {
        WebElement category;
        WebElement subCategory;
        ((JavascriptExecutor) getDriver()).executeScript("return window.onload");
        if ((new YandexMarket()).YandexMarketHeader.getAttribute("class").contains("n-header-vertical")) {
            new YandexMarket().marketAllCategories.click();
            //category = getDriver().findElement(By.xpath("//span[text() = '" + cat + "']/parent::a"));
            BasePage.wait.until(ExpectedConditions.elementToBeClickable(category = getDriver().findElement(By.xpath("//span[text() = '" + cat + "']/parent::a"))));
            new Actions(getDriver()).moveToElement(category).perform();
            subCategory = getDriver().findElement(By.xpath("//div[@class='n-navigation-vertical-menu']//a[text() = '" + subCat + "']"));
            BasePage.wait.until(ExpectedConditions.elementToBeClickable(subCategory));
            subCategory.click();
        } else {
            BasePage.wait.until(ExpectedConditions.elementToBeClickable(category = getDriver().findElement(By.xpath("//li[@data-department='" + cat + "']"))));
            new Actions(getDriver()).moveToElement(category).perform();
            subCategory = getDriver().findElement(By.xpath("//li[@data-department='" + cat + "']//a[text() = '" + subCat + "']"));
            BasePage.wait.until(ExpectedConditions.elementToBeClickable(subCategory));
            subCategory.click();
        }
    }

    @Тогда("^проверили, что на странице отображается \"(.+)\" предложений товара$")
    public void checkCountOfOffer(int countExpect) throws InterruptedException {
        ((JavascriptExecutor) getDriver()).executeScript("return window.onload");
        int countOffer = getDriver().findElements(By.xpath("//div[contains(@data-id,'model-')]")).size();
        Assert.assertTrue(String.format("Получено [%s]. Ожидалось [%s]", countOffer, countExpect),
                (countOffer==(int)countExpect));
    }

    @Когда("^дождались окончания загрузки на странице Яндекс-Маркет")
    public void waitEndOfLoadingOnYandexMarket() {
        ((JavascriptExecutor) getDriver()).executeScript("return window.onload");
        List<WebElement> loadElements = getDriver().findElements(By.xpath("//div[contains(@class,'progress_yes')]/parent::div[contains(@class,'preloadable')]"));
        BasePage.wait.until(ExpectedConditions.invisibilityOfAllElements(loadElements));
    }

    @Когда("^сохранили первое предложение как \"(.+)\"$")
    public void saveMarketOfferAs(String varSave) {
        String offer = getDriver().findElement(By.xpath("//div[contains(@class,'n-entrypoint-carousel_js_inited')]/../div[1]/div[1]/div[4]/div/div/a")).getText();
        BaseSteps.userHash.put(varSave,offer);
    }

    @Тогда("^открылась страница товара \"(.+)\"$")
    public void checkPageFindResult(String var) {
        ((JavascriptExecutor) getDriver()).executeScript("return window.onload");
        String nameProduct = new YandexMarket().titleProductPage.getText();
        String findProductName = (String)BaseSteps.userHash.get(var);
        Assert.assertTrue(String.format("открыто [%s]. Искали [%s]", nameProduct, findProductName),
                (nameProduct.contains(findProductName)));
    }

}







