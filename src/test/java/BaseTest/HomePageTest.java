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
    private static final String QUESTION = "//*[@id='accordion__heading-";// сам вопрос
    private static final String QUESTION_TEXT = "//*[@id='accordion__panel-";// текст который он раскрывает

    private final By byElementQuestion;
    private final By elementText;
    private final String equalsText;

    public HomePageTest(By byElementQuestion, By elementText, String equalsText) {
        this.byElementQuestion = byElementQuestion;
        this.elementText = elementText;
        this.equalsText = equalsText;
    }

    public static By getQuestionLocator(int index) {
        return By.xpath(QUESTION + index + "']");
    }

    public static By getTextLocator(int index) {
        return By.xpath(QUESTION_TEXT + index + "']/p");
    }

    public static final String getExpectedAnswers(int index) {
        return EXPECTED_ANSWERS[index];
    }

    private static final String[] EXPECTED_ANSWERS =                        // текст с которым происходит сравнение
            {       "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                    "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                    "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                    "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                    "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                    "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                    "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                    "Да, обязательно. Всем самокатов! И Москве, и Московской области."
            };

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        Object[][] parameters = new Object[8][];
        for (int i = 0; i < 8; i++) {
            parameters[i] = new Object[]{getQuestionLocator(i), getTextLocator(i), getExpectedAnswers(i)};
        }
        return parameters;
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
        homePage.testAllFieldText(byElementQuestion, elementText, equalsText);
    }

}
