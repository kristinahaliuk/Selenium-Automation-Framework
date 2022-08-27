package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LandingPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import java.util.List;


public class SearchItemsSteps {

    WebDriver driver= Driver.getInstance().getDriver();
    LandingPage landingPage=new LandingPage();

    @Given("I land on WebstaurantStore Page")
    public void i_land_on_WebstaurantStore_Page() {
        driver.get(ConfigurationReader.getProperty("config.properties","webstaurantstore.url"));
    }

    @Given("I search for {string}")
    public void i_search_for(String itemName) {
        landingPage.searchInputBox.sendKeys(itemName);
        landingPage.searchButton.click();

    }

    @Then("I Check the search result ensuring every product has the word {string} in its title")
    public void i_Check_the_search_result_ensuring_every_product_has_the_word_in_its_title(String target) {
        List<WebElement> listOfItems = landingPage.listOfItems(landingPage.listOfItemsLocator); // take all items of the first page and store into a list
        for(WebElement item: listOfItems){ // check if each item's title contains <target> in it
            Assert.assertTrue("Item title validation fail",item.getText().toLowerCase().contains(target.toLowerCase()));
        }
    }

    @Then("I Add the last of found items to Cart")
    public void i_Add_the_last_of_found_items_to_Cart(){
        /*
         * Since not all the items have the option to add to cart
         * I get all the items from the first page that has the option to add to cart
         * Then from that list I take the last item and add to cart
         * */
        List<WebElement> listOfItems = landingPage.listOfItems(landingPage.listOfItemsWithAddToCartLocator);
        listOfItems.get(listOfItems.size()-1).click();
        Assert.assertTrue("Add to Cart Validation Failed",landingPage.addToCartNotification.isDisplayed()); // once th item is added to cart I validate that the pop-up message is displayed


    }

    @Then("I am able to Empty Cart")
    public void i_Empty_Cart() {
        landingPage.viewCartButton.click();
        landingPage.emptyCartButton.click();
        landingPage.emptyCartButtonPopUp.click();
        Assert.assertTrue("Empty Cart message validation failed", landingPage.emptyCartHeader.isDisplayed());
    }






}
