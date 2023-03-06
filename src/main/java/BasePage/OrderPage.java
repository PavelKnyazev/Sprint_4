package BasePage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class OrderPage extends HomePage {
    /**
     * 1 часть страницы заказа
     */


    private static final By NAME = By.xpath("//input[@placeholder='* Имя']");  // локатор дял поля имени
    private static final By SECONDNAME = By.xpath("//input[@placeholder='* Фамилия']"); // локатор для поля фамилии
    private static final By ADRRESS = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"); // локатор для поля адреса
    private static final By METRO_STATION = By.xpath("//input[@placeholder='* Станция метро']"); // локатор для поля метро
    private static final By PHONE = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"); // локатор для телефона
    private static final By METRO_STATION_LIST = By.xpath("//div[@class='select-search__select']/ul/li"); // локатор для выпадающего списка метро

    private static final By NEXT_BUTTON = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // локатор кнопки дальше
    /**
     * вторая часть страницы заказа
     */
    private static final By CALENDAR_FIELD = By.xpath("//input[@placeholder='* Когда привезти самокат']"); //локатор для поля даты когда привезти самокат
    private static final By CALENDAR_LIST = By.xpath("//div[@role='button']");  // локатор для выпадающего календаря с днями месяца

    private static final By RENTAL_PERIOD = By.xpath("//div[@class='Dropdown-control']"); // локатор поля выбора периода аренды самоката
    private static final By RENTA_PERIOD_LIST = By.xpath("//div[@class='Dropdown-option']");// локатор дял выпадающего списка выбора времени аренды

    private static final By COLOR = By.xpath("//label[@class='Checkbox_Label__3wxSf']"); // локатор для поля выбора цвета

    private static final By COMMENTS_FIELD = By.xpath("//input[@placeholder='Комментарий для курьера']");// локатор для поля комментариев

    private static final By ORDER_BUTTON = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']"); // локатор для кнопки заказать
    private static final By YES_BUTTON = By.xpath("//button[text()='Да']"); // локатор для кнопки да в появляющемся окне подтверждения заказа
    private static final By CREATE_ORDER_WINDOW = By.xpath("//div[text()='Заказ оформлен']"); // локатор для сообщения , что заказ оформлен



    public OrderPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Метод возвращает случайное имя для тестов
     * @return
     */
    public String name() {
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("Павел");
        nameList.add("Валерия");
        nameList.add("Юрий");
        nameList.add("Владимир");
        nameList.add("Заур");
        nameList.add("Тимофей");
        return nameList.get((int) (Math.random() * nameList.size()));
    }

    /**
     * Метод возвращает случайную фамилию для тестов
     * @return
     */
    public String secondName() {
        ArrayList<String> secondNameList = new ArrayList<>();
        secondNameList.add("Лавров");
        secondNameList.add("Князев");
        secondNameList.add("Никулин");
        secondNameList.add("Патрушев");
        secondNameList.add("Гушко");
        secondNameList.add("Трегулов");

        return secondNameList.get((int) (Math.random() * secondNameList.size()));
    }

    /**
     * Метод возвращает случайный адрес для тестов
     * @return
     */
    public String adress() {
        ArrayList<String> adressList = new ArrayList<>();
        adressList.add("город Шатура, пер. Бухарестская, 49");
        adressList.add("город Лотошино, пр. Бухарестская, 60");
        adressList.add("город Клин, бульвар Будапештсткая, 04");
        adressList.add("город Коломна, въезд Ленина, 19");
        adressList.add("город Чехов, бульвар Домодедовская, 88");
        return adressList.get((int) (Math.random() * adressList.size()));
    }

    /**
     * Метод возвращает случайное 11 значное число имитирующее номер телефона для тестов
     * @return
     */
    public String randomPhone() {
        return String.valueOf((int) (Math.random() * (9999999999L - 11111111111L)) + 11111111111L);

    }

    /**
     * Метод возвращает случайную фразу для поля комментарий для курьера для тестов
     * @return
     */
    public String comments() {
        ArrayList<String> listComments = new ArrayList<>();
        listComments.add("- А у меня… кажется, нет характера… - Заведи. Вещь — полезная…");
        listComments.add("Иногда наука больше искусство, чем наука. Многие люди не понимают этого.");
        listComments.add("Тот, кого ты любишь, и тот, кто любит тебя, никогда не могут быть одним человеком.");
        listComments.add("Я видел сны и женщин во сне, и только сердце моё, обагрённое убийством, скрипело и текло");
        return listComments.get((int) (Math.random()*listComments.size()));

    }




    /**
     * Метод кликает на кнопку заказать на галвное странице, переходит на страницу
     * заказа и заполняет поля
     */
    public void orderTest() {
        clickElement(checkElementIsVisible(ORDER_BUTTON_UP)); // клик по элементу кнопки заказать на главной странице
        Assert.assertEquals(ORDER_URL, driver.getCurrentUrl());  // проверка перехода на нужный URL
//первая часть страницы заказа
        waitElementIsClickable(driver.findElement(NAME)).sendKeys(name()); // заполнение поля имени
        waitElementIsClickable(driver.findElement(SECONDNAME)).sendKeys(secondName());// заполнение поля фамилии
        waitElementIsClickable(driver.findElement(ADRRESS)).sendKeys(adress()); // заполнение поля адреса
        clickElement(checkElementIsVisible(METRO_STATION)); // кликает по полю станции метро дял того что бы выпал список станций метро
        List<WebElement> stationList = driver.findElements(METRO_STATION_LIST); // получает список станций метро
        clickElement(stationList.get((int) (Math.random() * stationList.size())));// выбирает из списка станцию метро случайным образом
        waitElementIsClickable(driver.findElement(PHONE)).sendKeys(randomPhone());// заполнение поля телефона
        clickElement(checkElementIsVisible(NEXT_BUTTON));// нажимает кнопку далее
 //вторая часть страницы заказа
        clickElement(checkElementIsVisible(CALENDAR_FIELD));// кликает по полю даты получения самоката для выпадения элемента календаря
        List<WebElement> calendarList = driver.findElements(CALENDAR_LIST);// получает список элементов дней из элемента календаря
        clickElement(calendarList.get((int) (Math.random() * calendarList.size())));// случайным образом выбирает один из дней
        clickElement(checkElementIsVisible(RENTAL_PERIOD));// кликает по полю срока аренды для выпадения списка возможных сроков
        List<WebElement> rentalRepiodList = driver.findElements(RENTA_PERIOD_LIST);// получает список возможных сроков аренды
        clickElement(rentalRepiodList.get((int) (Math.random() * rentalRepiodList.size())));// случайным образом выбирает один из них
        List<WebElement> colorList = driver.findElements(COLOR); // получает со страницы список элементов с возможными цветами
        clickElement(colorList.get((int) (Math.random() * colorList.size())));// случайным образом выбирает цвет
        waitElementIsClickable(driver.findElement(COMMENTS_FIELD)).sendKeys(comments());// заполняет поля комментариев
        waitElementIsClickable(driver.findElement(ORDER_BUTTON)).click(); // нажимает кнопку сделать заказ под полями ввода
        waitElementIsClickable(driver.findElement(YES_BUTTON)).click();// нажимает кнопку ДА в появившимся окне подтверждения заказа
        checkElementIsVisible( (CREATE_ORDER_WINDOW)); // проверяет появился ли элемент который говорит о успешном создании заказа






    }


}
