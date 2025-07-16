package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;

public class TextBox {

    @BeforeAll
    static void SizeBeforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillTextForm(){
        open("/text-box");
        $("#userName").setValue("Новый");
        $("#userEmail").setValue("novyy@list.ru");
        $("#currentAddress").setValue("Россия, Новая область, Новый район, поселок Новый, улица Новая, дом 4, квартира 44");
        $("#permanentAddress").setValue("Соответствует");
        $("#submit").click();

        $("#output #name").shouldHave(text("Новый"));
        $("#output #email").shouldHave(text("novyy@list.ru"));
        $("#output").$("#currentAddress").shouldHave(text("Россия, Новая область, Новый район, поселок Новый, улица Новая, дом 4, квартира 44"));
        $("#output").$("#permanentAddress").shouldHave(text("Соответствует"));
    }
}
