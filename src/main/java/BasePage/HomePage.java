package BasePage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public static final By COOCKIE = By.xpath("//button[@class='App_CookieButton__3cvqF']"); // кнопка принять куки
    public static final By ORDER_BUTTON_UP = By.xpath("//button[@class='Button_Button__ra12g']"); // кнопка заказать вверху страницы
    public static final By ORDER_BUTTON_DOWN = By.xpath("//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']"); // кнопка заказать внизу страницы
    protected static final String ORDER_URL = "https://qa-scooter.praktikum-services.ru/order";// URL страницы заказа

    /**
     * Переходит на URL
     */
    public void goToUrl(String url) {
        driver.get(url);
    }

    /**
     * Кликает по элементу
     */
    public void clickElement(WebElement element) {
        element.click();
    }

    /**
     * проверяет , есть ли элемент на странице
     */
    public WebElement checkElementIsVisible(By element) {

        WebElement webElement = (new WebDriverWait(driver, Duration.ofSeconds(10))).
                until((ExpectedConditions.visibilityOfElementLocated(element)));//ждем появления элемента
        return webElement;
    }

    /**
     * метод скроллер
     */
    public void scroll() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,50000)", "");
    }

    /**
     * нажимает на кнопку куки
     */
    public void coockies() {
        WebElement coockies = checkElementIsVisible(COOCKIE);
        if (coockies != null) {
            clickElement(coockies);
        }
    }

    /**
     * кликает на верхнюю кнопку заказа и сравнивает URL
     */
    public void testUpButton(){
        clickElement(checkElementIsVisible(ORDER_BUTTON_UP));
        Assert.assertEquals(ORDER_URL, driver.getCurrentUrl());
    }

    /**
     * кликает на нижнюю кнопку заказа и сравнивает URL
     */
    public void testDownButton(){
        clickElement(checkElementIsVisible(ORDER_BUTTON_DOWN));
        Assert.assertEquals(ORDER_URL, driver.getCurrentUrl());
    }

    /**
     * проверяет кликабельность элемента
     *
     *
     */
    public WebElement waitElementIsClickable(WebElement element){
        new WebDriverWait(driver,  Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    /**
     * Метод последовательно кликает на вебэлементы(вопросы) на странице и проверяет выпадает ли текст, далее сравнивает его с шаблоном
     */
    public void testAllFieldText(By byElementQuestion, By elementText, String equalsText) {
            clickElement(checkElementIsVisible(byElementQuestion)); // кликает по элементу
            WebElement webElement = (new WebDriverWait(driver, Duration.ofSeconds(10))).
                    until((ExpectedConditions.visibilityOfElementLocated(elementText)));//ждем появления элемента
            Assert.assertEquals(equalsText, webElement.getText()); // сравнивает текст
    }

}
