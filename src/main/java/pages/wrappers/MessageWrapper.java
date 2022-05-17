package pages.wrappers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MessageWrapper {
    private static final By xPathMessageText = By.xpath("//div[3]//msg-message[last()]//msg-parsed-text"); // //msg-message[last()]//msg-parsed-text
    private static final By xPathMessageTime = By.xpath(".//msg-time");
    private final SelenideElement message;
    private static final By xPathOptionsButton = By.xpath(".//msg-button[contains(@data-l,'t,messageActionmore')]");
    private static final By xPathDeleteButton = By.xpath("//msg-menu-item[contains(@data-l,'t,messageActionremove')]");
    private static final By xPathConfirmDeleteButton = By.xpath("//msg-button[contains(@data-tsid,'confirm-primary')]");

    public MessageWrapper(SelenideElement message) {
        message.shouldBe(visible.because("Message text not found!"));
        this.message = message;
    }

    public String getMessageText() {
        return $(xPathMessageText).shouldBe(Condition.visible.because("Message text not found!"))
                .getText();
    }

    public void deleteMessage() {
        message.shouldBe(visible.because("Message text not found!")).click();
        SelenideElement optionsButtonElem = message.$(xPathOptionsButton)
                .shouldBe(visible.because("Options button not found!"));
        optionsButtonElem.click();
        SelenideElement deleteButtonElem = $(xPathDeleteButton)
                .shouldBe(visible.because("Delete button not found!"));
        deleteButtonElem.click();
        SelenideElement confirmDeleteButtonElem = $(xPathConfirmDeleteButton)
                .shouldBe(visible.because("Confirm button not found!"));
        confirmDeleteButtonElem.click();
    }
}
