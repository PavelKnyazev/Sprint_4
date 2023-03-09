package BaseTest;

import org.junit.Test;

public class HomePageButtonTest extends SuperPage {




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
