import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by admin on 17.10.2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/autotests/"}, glue = {"autotest.steps"},
        plugin = {
                "autotest.util.AllureReporter",
        }
)
public class CucumberRunner {}
