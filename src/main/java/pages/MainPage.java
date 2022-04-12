package pages;

import com.codeborne.selenide.Condition;
import locators.MainPageLocators;
import pages.wrappers.ToolBarWrapper;

public class MainPage extends BasePage {
    ToolBarWrapper toolbar = new ToolBarWrapper(MainPageLocators.toolbar);

    public MainPage() {
        isLoaded();
    }

    @Override
    public void isLoaded() {
        MainPageLocators.element.shouldBe(Condition.visible.because("FullName not found"));
    }

    public MessagePage openMessage(){
        toolbar.getMessagesPage();
        return new MessagePage();
    }

    public String getFullName() {
        return MainPageLocators.element.getText();
    }

    public LoginPage exit() {
        toolbar.exit();
        return new LoginPage();
    }
}
