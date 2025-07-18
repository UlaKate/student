package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;

public class NewTestForm {

    @BeforeAll
    static void SizeBeforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillTextForm(){
        open("/automation-practice-form");
        $("#firstName").setValue("Зелёный");
        $("#lastName").setValue("Зеленов");
        $("#userEmail").setValue("zelenyy@test.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("2001");
        $(".react-datepicker__day--001").click();
        //$(byText("1")).click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("0011.png");
        $("#currentAddress").setValue("Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in");
        $("#react-select-3-input").setValue("N").pressEnter();
        $("#react-select-4-input").setValue("G").pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Зелёный Зеленов"));
        $(".table-responsive").shouldHave(text("zelenyy@test.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("01 April,2001"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("0011.png"));
        $(".table-responsive").shouldHave(text("Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in"));
        $(".table-responsive").shouldHave(text("NCR Gurgaon"));

    }
}
