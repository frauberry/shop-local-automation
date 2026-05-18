package website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static website.utils.DriverUtils.getDriver;
import static website.utils.DriverUtils.sleep;

public class HomePage {
    public By addToCartButton = By.xpath("//a[contains(text(),'Wireless')]/ancestor::div[@class='product-card']//button[contains(text(),'Add to Cart')]");
    public By itemCount = By.xpath("//span[text()='1']");
    public By searchField = By.id("search-input");
    public By searchItem = By.xpath("//a[text()='Classic Oxford Shirt']");
    public By sortDropdown = By.id("sort-select");
    public By lowToHighOption = By.xpath("//option[text()='Price: Low → High']");
    public By price = By.xpath("//*[@class='price-current']");


    public void addItemToTheCart() {
        sleep(2);
        getDriver().findElement(addToCartButton).click();
    }
    public void searchForTheItem() {
        getDriver().findElement(searchField).sendKeys("shirt");
    }
    public void sortItemsFromLowToHigh() {
        getDriver().findElement(sortDropdown).click();
        getDriver().findElement(lowToHighOption).click();
    }
    public boolean arePricesDisplayedFromLowToHigh() {
        List<WebElement> prices = getDriver().findElements(price);
        for (int i = 0; i < prices.size()-1; i++) {
            String price1 = prices.get(i).getText().substring(1);
            String  price2 = prices.get(i+1).getText().substring(1);
            if (Integer.parseInt(price1) > Integer.parseInt(price2)){
                return false;
            }
        }
        return true;
    }
}
