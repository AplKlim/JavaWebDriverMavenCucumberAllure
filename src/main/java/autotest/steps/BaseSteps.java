package autotest.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import autotest.util.TestProperties;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 17.10.2017.
 */
public class BaseSteps {
    private static WebDriver driver;
    private static Properties properties = TestProperties.getInstance().getProperties();
    public static HashMap<String, Object> userHash;
    public static WebDriver getDriver() {
        return driver;
    }


    @Before
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        driver .manage().window().maximize();
        driver .manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver .manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver .get(properties.getProperty("app.url"));
        userHash = new HashMap<String,Object> ();
    }

    @After
    public static void tearDown() throws Exception {
        userHash.clear();
        driver.quit();
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}