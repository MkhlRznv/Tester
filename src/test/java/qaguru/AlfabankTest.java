package qaguru;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfabankTest {
    @Test
    void testAlfa(){
        open("https://alfabank.ru");
        $(".t2lIQ").$(byText("В долларах США")).parent().click();
        $("[style=\"display: block;\"]").find(".form-control__input_1xotc").$("div input").click();
        $("[style=\"display: block;\"]").find(".form-control__input_1xotc").$("div input").setValue("0");
        $("[style=\"display: block;\"]").find(".d2lIQ").$("[data-test-id=\"amountAtTheEnd-all-value-usd\"]").shouldHave(text("1 003 000 $"));

    }
}
