package website.core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static final ThreadLocal <WebDriver> threadLocal = new ThreadLocal<>();

    public static void start(String browser, boolean headless) {
        ChromeOptions chromeOptions = new ChromeOptions();
        if(headless) {
            chromeOptions.addArguments("--headless=new");
        }

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.manage().window().maximize();
        threadLocal.set(driver);
    }

    public static WebDriver get() {
        return threadLocal.get();
    }

    public static void stop() {
        WebDriver driver = threadLocal.get();
        if(driver != null) {
            driver.quit();
            threadLocal.remove();
        }
    }


}
