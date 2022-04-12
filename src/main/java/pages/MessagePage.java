package pages;

import locators.MessagePageLocators;
import pages.wrappers.MessageWrapper;

public class MessagePage extends BasePage {

    public MessagePage() {
        isLoaded();
    }

    @Override
    public void isLoaded() {

    }

    public MessagePage openDialog(Long id){
        MessagePageLocators.findChat.click();
        return this;
    }

    public MessagePage sendMessage(String text){
        MessagePageLocators.lineInputMessage.setValue(text);
        MessagePageLocators.sendButton.click();
        return this;
    }

    public MessageWrapper getLastReceivedMessage(){
        return new MessageWrapper(MessagePageLocators.lastReceivedMessage);
    }

    public MessageWrapper getLastMyMessage(){
        return new MessageWrapper(MessagePageLocators.lastMyMessage);
    }
}
