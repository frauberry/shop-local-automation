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
}
