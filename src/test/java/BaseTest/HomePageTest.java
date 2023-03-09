package BaseTest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;




@RunWith(Parameterized.class)
public class HomePageTest extends SuperPage {


    /**
     * Константы с локаторами ведущими к вопросам
     */
    private static final By QUESTION_1 = By.xpath("//*[@id='accordion__heading-0']");  // сам вопрос
    private static final By QUESTION_1_TEXT = By.xpath("//*[@id='accordion__panel-0']/p"); // текст который он раскрывает
    private static final String EQUALS_TEXT_1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой."; // текст с которым происходит сравнение

    private static final By QUESTION_2 = By.xpath("//*[@id='accordion__heading-1']");
    private static final By QUESTION_2_TEXT = By.xpath("//*[@id='accordion__panel-1']/p");
    private static final String EQUALS_TEXT_2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

    private static final By QUESTION_3 = By.xpath("//*[@id='accordion__heading-2']");
    private static final By QUESTION_3_TEXT = By.xpath("//*[@id='accordion__panel-2']/p");
    private static final String EQUALS_TEXT_3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";

    private static final By QUESTION_4 = By.xpath("//*[@id='accordion__heading-3']");
    private static final By QUESTION_4_TEXT = By.xpath("//*[@id='accordion__panel-3']/p");
    private static final String EQUALS_TEXT_4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";

    private static final By QUESTION_5 = By.xpath("//*[@id='accordion__heading-4']");
    private static final By QUESTION_5_TEXT = By.xpath("//*[@id='accordion__panel-4']/p");
    private static final String EQUALS_TEXT_5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";

    private static final By QUESTION_6 = By.xpath("//*[@id='accordion__heading-5']");
    private static final By QUESTION_6_TEXT = By.xpath("//*[@id='accordion__panel-5']/p");
    private static final String EQUALS_TEXT_6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";

    private static final By QUESTION_7 = By.xpath("//*[@id='accordion__heading-6']");
    private static final By QUESTION_7_TEXT = By.xpath("//*[@id='accordion__panel-6']/p");
    private static final String EQUALS_TEXT_7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";

    private static final By QUESTION_8 = By.xpath("//*[@id='accordion__heading-7']");
    private static final By QUESTION_8_TEXT = By.xpath("//*[@id='accordion__panel-7']/p");
    private static final String EQUALS_TEXT_8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    private final By byElementQuestion;
    private final By elementText;
    private final String equalsText;

    public HomePageTest(By byElementQuestion, By elementText, String equalsText) {
        this.byElementQuestion = byElementQuestion;
        this.elementText = elementText;
        this.equalsText = equalsText;
    }







    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                { QUESTION_1, QUESTION_1_TEXT, EQUALS_TEXT_1},
                { QUESTION_2, QUESTION_2_TEXT, EQUALS_TEXT_2},
                { QUESTION_3, QUESTION_3_TEXT, EQUALS_TEXT_3},
                { QUESTION_4, QUESTION_4_TEXT, EQUALS_TEXT_4},
                { QUESTION_5, QUESTION_5_TEXT, EQUALS_TEXT_5},
                { QUESTION_6, QUESTION_6_TEXT, EQUALS_TEXT_6},
                { QUESTION_7, QUESTION_7_TEXT, EQUALS_TEXT_7},
                { QUESTION_8, QUESTION_8_TEXT, EQUALS_TEXT_8},

        };
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
        homePage.testAllFieldText(byElementQuestion,elementText,equalsText);


    }




}
