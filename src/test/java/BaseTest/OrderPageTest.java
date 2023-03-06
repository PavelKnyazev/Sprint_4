package BaseTest;

import org.junit.Test;

public class OrderPageTest extends HomePageTest {
    /**
     * Тест переходит на старницу оформления заказа, заполняет поля и проверяет офрмояется ли заказ
     */
    @Test
    public void orderTest1(){
        homePage.goToUrl(URL);
        homePage.coockies();
        orderPage.orderTest();
    }

    @Test
    public void orderTest2(){
        homePage.goToUrl(URL);
        homePage.coockies();
        orderPage.orderTest();
    }


}
