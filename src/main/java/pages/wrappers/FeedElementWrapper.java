package pages.wrappers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeNotEqual;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class FeedElementWrapper {
    private SelenideElement element;
    private final By feedAuthor = By.xpath(".//a[contains(@class, 'user-link o')]");
    private final By feedGroup = By.xpath(".//a[contains(@class, 'group-link o')]");
    private final By feedText = By.xpath(".//div[contains(@class, 'media-text_cnt_tx')]");
    private final By reactionButton = By.xpath(".//span[contains(@class,'js-klass-action')]");
    private final By reactionsTypeButtons = By.xpath("//span[@data-reaction-id]");
    private final By selectReactText = By.xpath(".//span[contains(@class,'widget_tx')]");

    public FeedElementWrapper(SelenideElement elem) {
        this.element = elem;
    }

    public boolean isByUser() {
        return element.$(feedAuthor).is(visible);
    }

    public boolean isByGroup() {
        return element.$(feedGroup).is(visible);
    }

    public String getAuthor() {
        SelenideElement feedAuthorElem = element.$(feedAuthor).shouldBe(visible.because("Author name not found!"));
        return feedAuthorElem.getText();
    }

    public String getText() {
        SelenideElement feedTextElem = element.$(feedText).shouldBe(visible.because("Note not found!"));
        return feedTextElem.getText();
    }

    public String setReaction(int numOfReaction) {
        SelenideElement reactionButtonElem = element.$(reactionButton)
                .shouldBe(visible.because("Reaction button not found!"));
        reactionButtonElem.hover();
        ElementsCollection reactionsTypeButtonsElements = $$(reactionsTypeButtons).shouldBe(sizeNotEqual(0)
                .because("Reactions not found"));
        SelenideElement react = reactionsTypeButtonsElements.get(numOfReaction);
        react = react.shouldBe(visible.because("Reaction not found!"));
        String reactionName = "data-reaction-text";
        String reactName = react.getAttribute(reactionName);
        react.click();

        return reactName;
    }

    public String getReactionName() {
        SelenideElement reactionButtonElem = element.$(reactionButton);
        SelenideElement selectReactTextElem = reactionButtonElem.$(selectReactText);
        return selectReactTextElem.getText();
    }
}
