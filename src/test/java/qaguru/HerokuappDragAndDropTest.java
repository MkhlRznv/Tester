package qaguru;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HerokuappDragAndDropTest {

    @Test
    void internetHerokuappWithDragAndDropTest() {
        // открыть страницу the-internet
        open("https://the-internet.herokuapp.com/");
        // найти и перейти по элементу с текстом "Drag and Drop"
        $(byText("Drag and Drop")).click();
        // Переместить прямоугольник А на место прямоугольника В
        $("#column-a").dragAndDropTo($("#column-b"));
        // Проверить, что прямоугольники поменялись местами
        $("#column-a").shouldHave(text("B"));

    }
    /*
     *  Тест при использовании actions() не срабатывает
     *
     *    @Test
     *    void internetHerokuappWithActions() {
     *
     *        open("https://the-internet.herokuapp.com/");
     *        $(byText("Drag and Drop")).click();
     *        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();
     *        $("#column-a").shouldHave(text("B"));
     *    }
     */
}
