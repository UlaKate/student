package github;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CheckSoftAssertions {

    @BeforeAll
    static void Sizebrouser(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1200";}

    @Test

    void SoftAssertions(){
        //Открыть страницу репозитория Selenide
        open("https://github.com/selenide/selenide");

        //Перейдите в раздел Wiki проекта
        $("[href='/selenide/selenide/wiki']").click();

        //Найти страницу SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");

        //Убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $("[href='/selenide/selenide/wiki/SoftAssertions']").shouldHave(text("Soft Assertions"));

        //Открыть страницу SoftAssertions, проверить что внутри есть пример кода для JUnit5
        $("[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $$("h4.heading-element").findBy(text("3. Using JUnit5 extend test class:")).should(exist);
    }
}
