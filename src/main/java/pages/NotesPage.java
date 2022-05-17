package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NotesPage extends BasePage {
    private final By optionList = By.xpath("//span[contains(@class,'new_topic_icodown')]");
    private final By deleteButton = By.xpath("(//div[contains(@id,'hook_Block_ShortcutMenu')]//a[contains(@class,'u-menu')])[last()]");

    @Override
    public void isLoaded() {
        $(optionList).shouldBe(visible.because("Не дождались загрузки кнопки дествий!"));
    }

    public void deleteLastNote() {
        SelenideElement optionListElem = $(optionList).shouldBe(visible.because("Option list not found!"));
        optionListElem.click();
        SelenideElement deleteButtonElem = $(deleteButton).shouldBe(visible.because("Delete button not found!"));
        deleteButtonElem.click();
    }
}
