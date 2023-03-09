package BaseTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderPageTest extends SuperPage {


    private final String name;
    private final String secondName;
    private final String adress;
    private final String phone;
    private final String comments;


    public OrderPageTest(String name, String secondName, String adress, String phone, String comments) {
        this.name = name;
        this.secondName = secondName;
        this.adress = adress;
        this.phone = phone;
        this.comments = comments;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getSumData() {
        return new Object[][] {
                { "Павел","Лавров", "город Шатура, пер. Бухарестская, 49", "11111111111","- А у меня… кажется, нет характера… - Заведи. Вещь — полезная…"},
                { "Юрий","Князев", "город Лотошино, пр. Бухарестская, 60", "11111111112","Иногда наука больше искусство, чем наука. Многие люди не понимают этого."},
                {"Владимир" ,"Патрушев", "город Клин, бульвар Будапештсткая, 04", "11111411111","Тот, кого ты любишь, и тот, кто любит тебя, никогда не могут быть одним человеком."},
                {"Тимофей" ,"Гушко", "город Коломна, въезд Ленина, 19", "11115111111","Я видел сны и женщин во сне, и только сердце моё, обагрённое убийством, скрипело и текло"},
        };
    }




    /**
     * Тест переходит на старницу оформления заказа, заполняет поля и проверяет офрмояется ли заказ
     */
    @Test
    public void orderTest(){
        homePage.goToUrl(URL);
        homePage.coockies();
        orderPage.orderTest(name,secondName,adress,phone,comments);
    }




}
