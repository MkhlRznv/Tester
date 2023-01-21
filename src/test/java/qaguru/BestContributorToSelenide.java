package qaguru;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {
    @Test
    void solntsevShouldBeTopContributor(){
        // открыть страницу репозитория селенида
        open("https://github.com/selenide/selenide");
        // подвести мышь к первому аватару из блока contributors
        $(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-cell") // ancestor - ищет ближайшего предка (т.е. вверх по дереву)
                .$$("ul li").first().hover();
        // проверка: во всплывающем окне есть текст Andrei Solntsev
//        $$(".Popover .Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
        $(".Popover .Popover-message").shouldHave(text("Andrei Solntsev"));
    }
}
