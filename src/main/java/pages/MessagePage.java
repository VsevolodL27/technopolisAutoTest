package pages;

import org.openqa.selenium.By;
import pages.wrappers.MessageWrapper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MessagePage extends BasePage {

    private final By lineForSearch = By.xpath("//input[@name='chat-search']");
    private final By lineInputMessage = By.xpath("//msg-input");
    private final By sendButton = By.xpath("//*[@data-l=\"t,sendButton\"]//*[@icon=\"send\"]");
    private final By lastReceivedMessage = By.xpath("//div[3]//msg-message[last()]");
    private String name;
    private final By findChat = By.xpath("//msg-parsed-text[contains(text(), " + name + ")]");

    public By getXPathLineForSearch() {
        return lineForSearch;
    }

    @Override
    public void isLoaded() {
        $(lineForSearch).shouldBe(visible.because("Search line didn't load!"));
    }

    public MessagePage openDialog(String userName) {
        $(findChat).click();
        return this;
    }

    public MessagePage sendMessage(String text) {
        $(lineInputMessage).setValue(text).shouldBe(visible.because("Chat not found!"));
        $(sendButton).click();
        return this;
    }

    public MessageWrapper getLastReceivedMessage() {
        return new MessageWrapper($(lastReceivedMessage));
    }
}
