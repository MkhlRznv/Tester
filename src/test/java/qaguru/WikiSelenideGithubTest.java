package qaguru;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class WikiSelenideGithubTest {
    @Test
    void testWikiSelenideToGithub() {
        // Открыть Github
        open("https://github.com/");
        // Открыть страницу Selenide в Github
        $("[placeholder=\"Search GitHub\"]").setValue("selenide").pressEnter();
        // Перейти в раздел Wiki проекта
        $(".col-12 nav").$(byText("Wikis")).click();
        //Убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki_search_results").shouldHave(text("SoftAssertions"));
        // Открыть страницу SoftAssertions
        $("#wiki_search_results").$("[title=\"SoftAssertions\"]").click();
        // Проверить что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5"));

    }
}
