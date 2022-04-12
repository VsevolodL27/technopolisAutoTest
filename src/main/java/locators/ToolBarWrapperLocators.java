package locators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ToolBarWrapperLocators {
    public static final SelenideElement xPathMessageButton = $(By.xpath(".//*[@data-l='t,messages']"));
    public static final SelenideElement xPathMiniToolbar =
            $(By.xpath(".//*[@class='ucard-mini toolbar_ucard js-toolbar-menu']"));
    public static final SelenideElement exitButton = $(By.xpath("//*[@data-l=\"t,logout\"]"));
    public static final SelenideElement confirmExitButton =
            $(By.xpath("//*[@class='form-actions __center']//*[@data-l='t,logout']"));
}
