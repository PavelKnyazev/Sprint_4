package BaseTest;

import BasePage.HomePage;
import BasePage.OrderPage;
import Config.ClientsFactory;
import org.junit.After;
import org.openqa.selenium.WebDriver;

public class SuperPage {
    protected static final String URL = "https://qa-scooter.praktikum-services.ru/";


    protected WebDriver driver = ClientsFactory.createDriver(); // получение вебдрайвера от фабрики клиентов

    protected HomePage homePage = new HomePage(driver);
    protected OrderPage orderPage = new OrderPage(driver);


    /**
     * Закрывает вебдрайвер после окончания тестов
     */

    @After
    public void closeDriver() {                // закрытие драйвера после теста
        if (driver != null) {
            driver.quit();
        }
    }
}
