package BaseTest;


import BasePage.HomePage;
import BasePage.OrderPage;
import Config.ClientsFactory;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class HomePageTest {

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

    /**
     * тест проверяет выпадает ли текст с вопросах внизу страницы
     * и сравнивает выпадающий текст с шаблоном
     */
    @Test
    public void testAll() {
        homePage.goToUrl(URL);
        homePage.scroll();
        homePage.coockies();
        homePage.testAllFieldText();


    }

    /**
     * тест проверяет ведет ли верхняя кнопка заказать на страницу оформоления заказа
     */
    @Test
    public void testUpButt() {
        homePage.goToUrl(URL);
        homePage.coockies();
        homePage.testUpButton();
    }


    /**
     * тест проверяет ведет ли нижняя кнопка заказать на страницу оформоления заказа
     */
    @Test
    public void testDownButt() {
        homePage.goToUrl(URL);
        homePage.coockies();
        homePage.scroll();
        homePage.testDownButton();
    }


}
