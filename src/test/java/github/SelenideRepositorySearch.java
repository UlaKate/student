package github;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SelenideRepositorySearch {

    @BeforeAll
    static void Sizebrouser(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1000";
    }

    @Test
    void ShouldSearchTopOfSelenide(){
        //Открыть гланую страницу
        open("https://github.com/");

        //Ввести в поле поиска Selenide и нажать Enter
        $(".search-input").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();

        //Кникнуть на первый репозиторий мз списка
        $("[href='/selenide/selenide']").click();

        //Проверка заголовка: selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));






    }
}

