package pages.wrappers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.MessagePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ToolBarWrapper {
    private static final By xPathMessageButton = By.xpath("//*[@id=\"msg_toolbar_button\"]/div[1]");
    private static final By xPathMiniToolbar =
            By.xpath(".//*[@class='ucard-mini toolbar_ucard js-toolbar-menu']");
    private static final By xPathExitButton = By.xpath("//*[@data-l=\"t,logout\"]");
    private static final By xPathConfirmExitButton =
            By.xpath("//*[@class='form-actions __center']//*[@data-l='t,logout']");
    private final SelenideElement toolbar;

    public ToolBarWrapper(SelenideElement toolbar) {
        this.toolbar = toolbar;
    }

    public void getMessagesPage() {
        $(xPathMessageButton).click();
    }

    public void openMiniToolbar() {
        $(xPathMiniToolbar).click();
    }

    public void exit() {
        openMiniToolbar();
        $(xPathExitButton).shouldBe(Condition.visible.because("Exit button not found")).click();
        $(xPathConfirmExitButton).shouldBe(Condition.visible.because("Confirm button not found")).click();
    }

    public MessagePage goToMessages() {
        SelenideElement messageButtonElem = toolbar.$(xPathMessageButton)
                .shouldBe(visible.because("Message button didn't load"));
        messageButtonElem.click();
        return new MessagePage();
    }
}
