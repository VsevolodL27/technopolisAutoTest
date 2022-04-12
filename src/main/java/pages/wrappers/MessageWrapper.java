package pages.wrappers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import locators.MessageWrapperLocators;

public class MessageWrapper {

    private final SelenideElement message;

    public MessageWrapper(SelenideElement message){
        this.message = message;
    }

    public String getMessageText(){
        return  MessageWrapperLocators.xPathMessageText.shouldBe(Condition.visible.because("Message text not found"))
                .getText();
    }
}
