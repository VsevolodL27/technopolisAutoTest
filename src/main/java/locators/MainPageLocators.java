package locators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPageLocators {
    public static final SelenideElement element = $(By.xpath("//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a/div"));
    public static final SelenideElement toolbar = $(By.xpath("//*[@id=\"msg_toolbar_button\"]/div[1]"));
}
