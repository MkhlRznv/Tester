package qaguru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        //открыть страницу
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать ентер
        $("[placeholder=\"Search GitHub\"]").setValue("selenide").pressEnter();
        // кликнуть на первый репозиторий из списка найденых
        $$("ul.repo-list li").first().$("a").click();
        // проверка заголовка selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));

    }
}
