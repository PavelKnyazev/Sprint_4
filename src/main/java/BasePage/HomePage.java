package BasePage;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class HomePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * Создаем коллекции дял последовательного перебора
     */
    ArrayList<By> ByElementQuestionList = new ArrayList<>();
    ArrayList<By> byTextElementList = new ArrayList<>();
    ArrayList<String> equalsTextList = new ArrayList<>();


    /**
     * инициализируем коллекции константами
     */
    {

        ByElementQuestionList.add(QUESTION_1);
        ByElementQuestionList.add(QUESTION_2);
        ByElementQuestionList.add(QUESTION_3);
        ByElementQuestionList.add(QUESTION_4);
        ByElementQuestionList.add(QUESTION_5);
        ByElementQuestionList.add(QUESTION_6);
        ByElementQuestionList.add(QUESTION_7);
        ByElementQuestionList.add(QUESTION_8);
        byTextElementList.add(QUESTION_1_TEXT);
        byTextElementList.add(QUESTION_2_TEXT);
        byTextElementList.add(QUESTION_3_TEXT);
        byTextElementList.add(QUESTION_4_TEXT);
        byTextElementList.add(QUESTION_5_TEXT);
        byTextElementList.add(QUESTION_6_TEXT);
        byTextElementList.add(QUESTION_7_TEXT);
        byTextElementList.add(QUESTION_8_TEXT);
        equalsTextList.add(EQUALS_TEXT_1);
        equalsTextList.add(EQUALS_TEXT_2);
        equalsTextList.add(EQUALS_TEXT_3);
        equalsTextList.add(EQUALS_TEXT_4);
        equalsTextList.add(EQUALS_TEXT_5);
        equalsTextList.add(EQUALS_TEXT_6);
        equalsTextList.add(EQUALS_TEXT_7);
        equalsTextList.add(EQUALS_TEXT_8);


    }

    /**
     * Константы с локаторами ведущими к вопросам
     */
    public static final By QUESTION_1 = By.xpath("//*[@id='accordion__heading-0']");  // сам вопрос
    public static final By QUESTION_1_TEXT = By.xpath("//*[@id='accordion__panel-0']/p"); // текст который он раскрывает
    public static final String EQUALS_TEXT_1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой."; // текст с которым происходит сравнение

    public static final By QUESTION_2 = By.xpath("//*[@id='accordion__heading-1']");
    public static final By QUESTION_2_TEXT = By.xpath("//*[@id='accordion__panel-1']/p");
    public static final String EQUALS_TEXT_2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

    public static final By QUESTION_3 = By.xpath("//*[@id='accordion__heading-2']");
    public static final By QUESTION_3_TEXT = By.xpath("//*[@id='accordion__panel-2']/p");
    public static final String EQUALS_TEXT_3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";

    public static final By QUESTION_4 = By.xpath("//*[@id='accordion__heading-3']");
    public static final By QUESTION_4_TEXT = By.xpath("//*[@id='accordion__panel-3']/p");
    public static final String EQUALS_TEXT_4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";

    public static final By QUESTION_5 = By.xpath("//*[@id='accordion__heading-4']");
    public static final By QUESTION_5_TEXT = By.xpath("//*[@id='accordion__panel-4']/p");
    public static final String EQUALS_TEXT_5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";

    public static final By QUESTION_6 = By.xpath("//*[@id='accordion__heading-5']");
    public static final By QUESTION_6_TEXT = By.xpath("//*[@id='accordion__panel-5']/p");
    public static final String EQUALS_TEXT_6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";

    public static final By QUESTION_7 = By.xpath("//*[@id='accordion__heading-6']");
    public static final By QUESTION_7_TEXT = By.xpath("//*[@id='accordion__panel-6']/p");
    public static final String EQUALS_TEXT_7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";

    public static final By QUESTION_8 = By.xpath("//*[@id='accordion__heading-7']");
    public static final By QUESTION_8_TEXT = By.xpath("//*[@id='accordion__panel-7']/p");
    public static final String EQUALS_TEXT_8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

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

    public void testUpButton(){
        clickElement(checkElementIsVisible(ORDER_BUTTON_UP));
        Assert.assertEquals(ORDER_URL, driver.getCurrentUrl());
    }
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
    public void testAllFieldText() {
        for (int i = 0; i <= 7; i++) {
            clickElement(checkElementIsVisible(ByElementQuestionList.get(i))); // кликает по элементу
            WebElement webElement = (new WebDriverWait(driver, Duration.ofSeconds(10))).
                    until((ExpectedConditions.visibilityOfElementLocated(byTextElementList.get(i))));//ждем появления элемента
            Assert.assertEquals(equalsTextList.get(i), webElement.getText()); // сравнивает текст
        }




    }








}
