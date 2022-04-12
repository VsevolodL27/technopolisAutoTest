package locators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MessageWrapperLocators {
    public final static SelenideElement xPathMessageText = $(By.xpath(".//msg-parsed-text"));
    public final static SelenideElement xPathMessageTime = $(By.xpath(".//msg-time"));
}
