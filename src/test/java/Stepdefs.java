import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import website.core.driver.DriverManager;
import website.pages.AccountPage;
import website.pages.HomePage;
import website.pages.LoginPage;
import website.utils.DriverUtils;

public class Stepdefs {

    private static final String HOME_PAGE_URL = "http://localhost:3011/";
    private static final String LOGIN_PAGE_URL = "http://localhost:3011/login.html";
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;

    @Before
    public void setUp() {
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        DriverManager.start("chrome", headless);
        homePage = new HomePage();
        loginPage = new LoginPage();
        accountPage = new AccountPage();
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

    @Then("Products should display in the low to high order")
    public void productsDisplayInTheLowToHighOrder() {
        Assertions.assertThat(homePage.arePricesDisplayedFromLowToHigh()).isTrue();
    }

    @When("User sorts products from high to low")
    public void userSortsProductsFromHighToLow() {
        homePage.sortItemsFromHighToLow();
    }

    @Then("Products should display in the high to low order")
    public void productsDisplayInTheHighToLowOrder() {
        Assertions.assertThat(homePage.arePricesDisplayedFromHighToLow()).isTrue();
    }

    @When("User sorts products from top rated to less rated")
    public void userSortsProductsFromTopRatedToLessRated() {
        homePage.sortItemsFromTopRated();
    }

    @Then("Top rated products should display first")
    public void topRatedProductsShouldDisplayFirst() {
        Assertions.assertThat(homePage.isRateDisplayedFromTopRated()).isTrue();
    }

    @When("User changes view to List View")
    public void userChangesViewToListView() {
        homePage.changeViewToListView();
    }

    @Then("Products should be displayed in the List View")
    public void productsShouldBeDisplayInTheListView() {
        Assertions.assertThat(homePage.isListViewDisplayed()).isTrue();
    }

    @When("User changes view to Grid View")
    public void userChangesViewToGridView() {
        homePage.changeViewToListView();
        homePage.changeViewToGridView();
    }

    @Then("Products should be displayed in the Grid View")
    public void productsShouldBeDisplayedInTheGridView() {
        Assertions.assertThat(homePage.isGridViewDisplayed()).isTrue();
    }

    @Given("User is on Login page")
    public void userIsOnLoginPage() {
        DriverManager.get().navigate().to(LOGIN_PAGE_URL);
    }

    @When("User signs in")
    public void userSignsIn() {
        loginPage.signIn();
    }

    @Then("User should be successfully signed in")
    public void userShouldBeSuccessfullySignedIn() {
        Assertions.assertThat(homePage.isAccountNameDisplayed()).isTrue();
    }

    @When("User fills out fields")
    public void userFillsOutFields() {
        loginPage.fillOutFields();
    }

    @And("User creates a new account")
    public void userCreatesANewAccount() {
        loginPage.createAccount();
    }

    @Then("A new account should be created")
    public void aNewAccountShouldBeCreated() {
        Assertions.assertThat(homePage.isAccountNameDisplayed()).isTrue();
    }

    @Given("User is on Account page")
    public void userIsOnAccountPage() {
        DriverManager.get().navigate().to(LOGIN_PAGE_URL);
        loginPage.signIn();
    }

    @When("User signs out")
    public void userSignsOut() {
        homePage.redirectToAccount();
        accountPage.signOut();
    }

    @Then("User should be successfully sign out")
    public void userShouldBeSuccessfullySignOut() {
        Assertions.assertThat(homePage.isSignInIconDisplayed()).isTrue();
    }

    @When("User continues shopping without an account")
    public void userContinuesShoppingWithoutAnAccount() {
        loginPage.continueShoppingWithNoAccount();
    }

    @Then("User should land on Home Page")
    public void userShouldLandOnHomePage() {
        Assertions.assertThat(homePage.isSignInIconDisplayed()).isTrue();
    }

    @When("User signs in with empty fields")
    public void userSignsInWithEmptyFields() {
        loginPage.signInWithEmptyFields();
    }

    @Then("Error is displayed")
    public void errorIsDisplayed() {
        Assertions.assertThat(!loginPage.getInlineErrors().contains(false)).isTrue();
    }

    @When("User signs in with empty password field")
    public void userSignsInWithEmptyPasswordField() {
        loginPage.signInWithEmptyPasswordField();
    }

    @Then("Password Inline Error is displayed")
    public void passwordInlineErrorIsDisplayed() {
        Assertions.assertThat(loginPage.isPasswordErrorDisplayed()).isTrue();
    }

    @When("User signs in with empty email field")
    public void userSignsInWithEmptyEmailField() {
        loginPage.signInWithEmptyEmailField();
    }

    @Then("Email Inline Error is displayed")
    public void emailInlineErrorIsDisplayed() {
        Assertions.assertThat(loginPage.isEmailErrorDisplayed()).isTrue();
    }

    @When("User enters invalid {string} email")
    public void userEntersInvalidEmail(String email) {
        loginPage.enterEmail(email);
    }

    @Then("Email Inline Error {string} message should be displayed")
    public void emailInlineErrorMessageShouldBeDisplayed(String errorMessage) {
        Assertions.assertThat(loginPage.isInlineEmailErrorDisplayed(errorMessage)).isTrue();
    }
}
