package website.pages;

import org.openqa.selenium.By;

import static website.utils.DriverUtils.getDriver;

public class CartPage {
    public By quantityDisplay = By.xpath("//span[@class='qty-display']");

    public int getCartItemQuantity() {
        return Integer.parseInt(getDriver().findElement(quantityDisplay).getText());
    }
}
