package Config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static Config.Config.BROWSER_AND_PLATFORM;

/**
 * Фабрика клиентов в зависимости от установленной константы будет создаваться соответсвующий вебдрайвер
 */
public class ClientsFactory {


    public static WebDriver createDriver() {
        WebDriver driver = null;
        switch (BROWSER_AND_PLATFORM) {
            case "CHROME":
                ChromeOptions options = new ChromeOptions();
               // options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;
            case "MOZILLA":
                FirefoxOptions options1 = new FirefoxOptions();
                //options1.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(options1);
                break;

            default:
                Assert.fail("INCORECT BROWSER NAME " + BROWSER_AND_PLATFORM);
        }

        driver.manage().window().maximize();    // разворачивание окна браузера на весь экран

        return driver;
    }


//    ChromeOptions options = new ChromeOptions();
//options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
//    WebDriver driver = new ChromeDriver(options);
}
