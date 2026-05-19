import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import website.core.driver.DriverManager;
import website.pages.HomePage;
import website.utils.DriverUtils;

public class Stepdefs {

    private static final String HOME_PAGE_URL = "http://localhost:3011/";
    private HomePage homePage;

    @Before
    public void setUp() {
        DriverManager.start("chrome", false);
        homePage = new HomePage();
    }

    @After
    public void tearDown() {
        DriverManager.stop();
    }

    @Given("^User is on Home page$")
    public void userIsOnHomePage() {
        DriverManager.get().navigate().to(HOME_PAGE_URL);
    }

    @When("^User adds a product to the cart$")
    public void userAddsAProductToTheCart() {
        DriverUtils.scrollDownToElement(homePage.addToCartButton);
        homePage.addItemToTheCart();
    }

    @Then("^Items number bubble should be displayed on the cart icon$")
    public void itemsNumberBubbleShouldBeDisplayedOnTheCartIcon() {
        Assertions.assertThat(DriverUtils.waitElementToBeVisible(homePage.itemCount, 10).isDisplayed()).isTrue();
    }

    @When("User searches for a product")
    public void userSearchesForAProduct() {
        homePage.searchForTheItem();
    }

    @Then("The product name should be displayed")
    public void theProductNameShouldBeDisplayed() {
        Assertions.assertThat(DriverUtils.waitElementToBeVisible(homePage.searchItem, 10).isDisplayed()).isTrue();
    }

    @When("User sorts products from low to high")
    public void userSortsProductsFromLowToHigh() {
        homePage.sortItemsFromLowToHigh();
    }

    @Then("Products display in the low to high order")
    public void productsDisplayInTheLowToHighOrder() {
        Assertions.assertThat(homePage.arePricesDisplayedFromLowToHigh()).isTrue();
    }

    @When("User sorts products from high to low")
    public void userSortsProductsFromHighToLow() {
        homePage.sortItemsFromHighToLow();
    }

    @Then("Products display in the high to low order")
    public void productsDisplayInTheHighToLowOrder() {
        Assertions.assertThat(homePage.arePricesDisplayedFromHighToLow()).isTrue();
    }
}
