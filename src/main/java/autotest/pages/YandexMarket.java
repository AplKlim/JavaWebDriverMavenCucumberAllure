package autotest.pages;

import autotest.steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by admin on 20.10.2017.
 */
public class YandexMarket extends BasePage {

    public YandexMarket(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }





/////////////Elements

    @FindBy(xpath = "//span[contains(text(),'Все категории')][@class='button__text']/parent::button")
    public WebElement marketAllCategories;

    @FindBy(xpath = "//div[@class='main']/div[@class][1]")
    public WebElement YandexMarketHeader;

    @FindBy(xpath = "//input[@id='glf-pricefrom-var']")
    public WebElement marketFilterFieldLowPrice;

    @FindBy(xpath = "//span[@class='button__text'][text()='Применить']/..")
    public WebElement marketFilterUse;

    @FindBy(xpath = "//label[@class='checkbox__label'][text()='Samsung']")
    public WebElement marketFilterCheckBoxSumsung;

    @FindBy(xpath = "//label[@class='checkbox__label'][text()='LG']")
    public WebElement marketFilterCheckBoxLG;

    @FindBy(xpath = "//input[@id ='header-search']")
    public WebElement searchField;

    @FindBy(xpath = "//span[@class ='button2__text'][text() = 'Найти']/..")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class = 'n-title__text']/h1")
    public WebElement titleProductPage;

}
