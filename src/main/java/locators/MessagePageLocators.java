package locators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MessagePageLocators {
    public final SelenideElement lineForSearch = $(By.xpath("//input[@name='chat-search']"));
    public static final SelenideElement lineInputMessage = $(By.xpath("//msg-input"));
    public static final SelenideElement sendButton = $(By.xpath("//*[@data-l=\"t,sendButton\"]//*[@icon=\"send\"]"));
    public static final SelenideElement lastReceivedMessage =
            $(By.xpath("//*[@class=\"group\"][last()]//msg-message[not(@mine)][last()]"));
    public static final SelenideElement lastMyMessage =
            $(By.xpath("//*[@class=\"group\"][last()]//msg-message[@mine][last()]"));
    private static String id;
    public static final SelenideElement findChat = $(By.xpath("//msg-chats-list-item//*[@id='" + id + "']"));
}
