package step_definitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;
import utilities.Driver;
import java.time.Duration;


/*
 * Hooks by using @Before and @After annotations from cucumber class
 * They will run before and after each Scenario
 * */


public class Hooks {
    public WebDriver driver;


    @Before
    public void setUp() {
        Driver.getInstance().setDriver(BrowserFactory.createInstance());
        driver = Driver.getInstance().getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.getInstance().removeDriver();
    }
}