package qaguru;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamplesLecture {

    @Test
    void cssXpathExamples() {

        //Если есть специальный селектор для автотестов "data-testid" - называться может по разному
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
        $("[data-testid=email]").setValue("1");
        $(by("data-testid", "email")).setValue("1");
        $("input.login_form_input_box[name=email]#email[data-testid=email]").setValue("1"); // не лучший вариант перечсления всех уточняющих атрубутов


        //В случае если нет специального селектора для автотестов, есть "id"
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email">
        $("[id=email]").setValue("1");
        $("#email").setValue("1");
        $("input#email").setValue("1");
        $x("//input[@id='email']");
        $x("//*[@id='email']"); // * - означает любой элемент с необходимым элементом внутри

        //В случае нахождения элемента по тегу "name"
        // <input type="email" class="inputtext login_form_input_box" name="email">
        $("[name=email]").setValue("1");
        $(byName("email")).setValue("1");

        //В случае нахождения элемента по классу
        // <input type="email" class="inputtext login_form_input_box">
        $("[class=login_form_input_box]").setValue("1");
        $(".login_form_input_box").setValue("1");
        $("inputtext.login_form_input_box").setValue("1");
        $x("//input[@class='inputtext'][@class='login_form_input_box']").setValue("1");

        //В случае вложенного элемента
        /*
        <div class="inputtext">
            <input type="email" class="login_form_input_box">
        </div>
         */
        $("inputtext .login_form_input_box").setValue("1"); // добавляется пробел, указывает на то что эдемент вложен
        $("inputtext").$(".login_form_input_box").setValue("1");

        //Находим элемент по тексту
        // <div>Hello qa.guru</div>
        $x("//div[text()='Hello qa.guru']").click();
        $(byText("Hello qa.guru")).click();
        $(withText(("Hello qa.guru"))).click(); // "withText" - Ищет по подстроке

    }
}
