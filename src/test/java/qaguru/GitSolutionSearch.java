package qaguru;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitSolutionSearch {
    @Test
    void GitSolutionSearch() {

        // отрыть github
        open("https://github.com/");
        //навести курсор на элемент с текстом Solution
        $(".HeaderMenu-item", 1).hover();
        // найти в выпадающем окне элемент с текстом Enterprise, перейти по нему
        $(byText("Enterprise")).click();
        // Проверка, что загрузилась нужная страница, присутствует текст "Build like the best"
        $(".application-main").shouldHave(text("Build like the best"));
    }
}
