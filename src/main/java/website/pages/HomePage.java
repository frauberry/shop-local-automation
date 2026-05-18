package website.pages;

import org.openqa.selenium.By;

import static website.utils.DriverUtils.getDriver;
import static website.utils.DriverUtils.sleep;

public class HomePage {
    public By addToCartButton = By.xpath("//a[contains(text(),'Wireless')]/ancestor::div[@class='product-card']//button[contains(text(),'Add to Cart')]");
    public By itemCount = By.xpath("//span[text()='1']");

    public void addItemToTheCart() {
        sleep(2);
        getDriver().findElement(addToCartButton).click();
    }
}
