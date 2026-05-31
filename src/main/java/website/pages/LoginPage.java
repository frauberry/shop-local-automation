package website.pages;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static website.utils.DriverUtils.getDriver;
import static website.utils.TestData.generateEmail;

public class LoginPage {
    public By createAccountTab = By.id("register-tab");
    public By fullName = By.id("reg-name");
    public By regEmail = By.id("reg-email");
    public By regPassword = By.id("reg-password");
    public By regConfirmPassword = By.id("reg-confirm");
    public By createAccountButton = By.id("register-btn");
    public By signInEmail = By.id("login-email");
    public By signInPassword = By.id("login-password");
    public By signInButton = By.id("login-btn");
    public By continueShoppingButton = By.xpath("//a[contains(text(),'Continue')]");
    public By emailError = By.id("login-email-error");
    public By passwordError = By.id("login-password-error");
    public String emailErrorMessage = "//span[contains(text(),'%s')]";

    public void fillOutFields() {
        String email = generateEmail();
        getDriver().findElement(createAccountTab).click();
        getDriver().findElement(fullName).sendKeys("Olga Sachkova");
        getDriver().findElement(regEmail).sendKeys(email);
        getDriver().findElement(regPassword).sendKeys("olga123!");
        getDriver().findElement(regConfirmPassword).sendKeys("olga123!");
    }
    public void createAccount() {
        getDriver().findElement(createAccountButton).click();
    }
    public void signIn() {
        getDriver().findElement(signInEmail).sendKeys("olga12345@yopmail.com");
        getDriver().findElement(signInPassword).sendKeys("olga123!");
        getDriver().findElement(signInButton).click();
    }
    public void continueShoppingWithNoAccount() {
        getDriver().findElement(continueShoppingButton).click();
    }
    public void signInWithEmptyFields() {
        getDriver().findElement(signInButton).click();
    }
    public List <Boolean> getInlineErrors() {
        List <Boolean> errors = new ArrayList<>();
        errors.add(getDriver().findElement(emailError).isDisplayed());
        errors.add(getDriver().findElement(passwordError).isDisplayed());
        return errors;
    }
    public void signInWithEmptyPasswordField() {
        String email = generateEmail();
        getDriver().findElement(signInEmail).sendKeys(email);
        getDriver().findElement(signInButton).click();
    }
    public boolean isPasswordErrorDisplayed() {
        return getDriver().findElement(passwordError).isDisplayed();
    }
    public void signInWithEmptyEmailField() {
        getDriver().findElement(signInPassword).sendKeys("olga123!");
        getDriver().findElement(signInButton).click();
    }
    public boolean isEmailErrorDisplayed() {
        return getDriver().findElement(emailError).isDisplayed();
    }
    public void enterEmail(String email) {
        getDriver().findElement(signInEmail).sendKeys(email);
        getDriver().findElement(signInButton).click();
    }
    public boolean isInlineEmailErrorDisplayed(String errorMessage) {
        return getDriver().findElement(By.xpath(String.format(emailErrorMessage,errorMessage))).isDisplayed();
    }
}
