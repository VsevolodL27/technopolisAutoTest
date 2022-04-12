package pages.wrappers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import locators.ToolBarWrapperLocators;

public class ToolBarWrapper {
    private final SelenideElement toolbar;

    public ToolBarWrapper(SelenideElement toolbar){
        this.toolbar = toolbar;
    }

    public void getMessagesPage(){
        ToolBarWrapperLocators.xPathMessageButton.click();
    }

    public void openMiniToolbar(){
        ToolBarWrapperLocators.xPathMiniToolbar.click();
    }
    public void exit(){
        openMiniToolbar();
        ToolBarWrapperLocators.exitButton.shouldBe(Condition.visible.because("Exit button not found")).click();
        ToolBarWrapperLocators.confirmExitButton.shouldBe(Condition.visible.
                because("Confirm button not found")).click();
    }
}
