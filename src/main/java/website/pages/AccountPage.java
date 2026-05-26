package website.pages;

import org.openqa.selenium.By;

import static website.utils.DriverUtils.getDriver;
import static website.utils.DriverUtils.sleep;

public class AccountPage {
    By signOutButton = By.id("logout-btn");

    public void signOut() {
        getDriver().findElement(signOutButton).click();
    }
}
