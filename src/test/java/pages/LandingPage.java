package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class LandingPage {

    WebDriver driver;
    public By listOfItemsLocator = By.id("ProductBoxContainer");
    public By listOfItemsWithAddToCartLocator = By.name("addToCartButton");

    public LandingPage() {
        this.driver = Driver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "searchval")
    public WebElement searchInputBox;

    @FindBy(xpath = "//button[@value='Search']")
    public WebElement searchButton;

    @FindBy(css=".notification__heading")
    public WebElement addToCartNotification;

    @FindBy(xpath = "//a[(text() = 'View Cart')]")
    public WebElement viewCartButton;

    @FindBy(xpath = "//button[(text()='Empty Cart')]")
    public WebElement emptyCartButton;

    @FindBy(xpath = "//h2[@id='empty-cart-title']/../..//button[text()='Empty']")
    public WebElement emptyCartButtonPopUp;

    @FindBy(className = "header-1")
    public WebElement emptyCartHeader;


    /*
     * Reusable method that will return a list of WebElements from the first page
     * */
    public List<WebElement> listOfItems(By locator) {
        return driver.findElements(locator);
    }

}
