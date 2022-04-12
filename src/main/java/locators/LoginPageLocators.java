package locators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageLocators {
    public static final SelenideElement xPathLogin = $(By.xpath("//*[@id=\"field_email\"]"));
    public static final SelenideElement xPathPassword = $(By.xpath("//*[@id=\"field_password\"]"));
}
