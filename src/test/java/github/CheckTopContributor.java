package github;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CheckTopContributor {

    @BeforeAll
    static void Sizebrouser(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1200";
    }

    @Test
    void TopContributor(){
        //Открыть страницу репозитория Selenide
        open("https://github.com/selenide/selenide");

        $(".BorderGrid-row").scrollIntoView(true);

        //Подвести мышку к первой иконки в списке Contributors
        $("[href='https://github.com/asolntsev']").hover();
        //$$("ul.list-style-none li").first().$(".mb-2");

        $(".Popover-message").shouldHave(text("Andrei Solntsev"));

    }


}
