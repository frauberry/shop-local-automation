package website.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import website.core.driver.DriverManager;

import java.time.Duration;

public class DriverUtils {

    private DriverUtils() {}

    public static WebDriver getDriver() {
        return DriverManager.get();
    }

    public static WebElement waitElementToBeVisible(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitElementToBeClickable(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void sleep(int seconds) {
        try{
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {}
    }

    public static void scrollDownToElement(By by) {
        WebElement element = getDriver().findElement(by);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                element
        );
    }
}
