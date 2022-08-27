package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Locale;


public class BrowserFactory {

    /*
     * Method will create an instance based on the value we provide in our terminal
     * If we do not provide any value for attribute browser then by default ChromeBrowser will be initialized
     * */

    public static WebDriver createInstance() {

        WebDriver driver = null;

        if (System.getProperty("browser") == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else {

            String browserType = System.getProperty("browser").toUpperCase();

            switch (browserType) {
                case "FIREFOX" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case "EDGE" -> {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
                case "SAFARI" -> {
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                }
                default -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }
        }


        return driver;
    }


}
