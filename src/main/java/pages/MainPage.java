package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.wrappers.FeedElementWrapper;
import pages.wrappers.NewNote;
import pages.wrappers.ToolBarWrapper;

import java.util.ArrayList;
import java.util.Optional;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage extends BasePage {

    private final By userFullName = By.xpath("//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a/div");
    private final By textNoteStarter = By.xpath("//a[contains(@class, 'pf-head_itx_a')]");
    private final By element = By.xpath("//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a/div");
    private final By xPathToolbar = By.xpath("//*[@id=\"msg_toolbar_button\"]/div[1]");
    private final By feedElements = By.xpath("//div[contains(@class, 'feed-w')]");
    private final By notePageButton = By.xpath("//a[contains(@data-l,'t,userStatuses')]");
    private final By xPathAvatar = By.xpath("//img[contains(@id, 'viewImageLinkId')]");
    private final By changePhoto = By.xpath("//div[contains(text(), 'Сменить фото')]");
    private final By privatePhoto = By.xpath
            ("//*[@id=\"hook_Block_PopLayer\"]/div/change-user-avatar/ui-part/div/photo-picker/div/div/div[2]" +
                    "/div/div[3]/div[2]/div[2]/div[1]/div[1]/div/a/div/div");
    private final By choosePhoto = By.xpath
            ("//*[@id='hook_Block_PopLayer']/div/change-user-avatar/ui-part/div/photo-picker/div/div/div[2]" +
                    "/div/div[3]/div[2]/div/div/div/div[1]/div/img");
    private final By agreeButton = By.xpath("//span[contains(text(), 'Установить')]");
    private final By xPathPhoto = By.xpath("//img[contains(@class, 'image-layer_img image__4rmea')]");
    private final By cancelButton = By.xpath("//a[contains(@id, 'cancel')]");

    ToolBarWrapper toolbar = new ToolBarWrapper($(xPathToolbar));

    @Override
    public void isLoaded() {
        $(userFullName).shouldBe(visible.because("Didn't wait for element with username to load!"));
        $(textNoteStarter).shouldBe(visible.because("Didn't wait for the button to load to create posts!"));
    }

    public MessagePage openMessage() {
        toolbar.getMessagesPage();
        return new MessagePage();
    }

    public String getFullName() {
        return $(element).getText();
    }

    public LoginPage exit() {
        toolbar.exit();
        return new LoginPage();
    }

    public MessagePage openMessagePage() {
        return toolbar.goToMessages();
    }

    public ArrayList<FeedElementWrapper> getFeedList() {
        ArrayList<FeedElementWrapper> feedList = new ArrayList<>();
        for (SelenideElement elem : $$(feedElements)) {
            feedList.add(new FeedElementWrapper(elem));
        }
        return feedList;
    }

    public Optional<FeedElementWrapper> getLastFeedByUsername(String username) {
        for (FeedElementWrapper elem : getFeedList()) {
            if (elem.isByUser() && elem.getAuthor().equals(username)) {
                return Optional.of(elem);
            }
        }
        return Optional.empty();
    }

    public NotesPage openNotePage() {
        SelenideElement notePageButtonElem = $(notePageButton).shouldBe(visible.because("Кнопка перехода на траницу заметок не отображается!"));
        notePageButtonElem.click();
        return new NotesPage();
    }

    public MainPage makeNote(NewNote note) {
        SelenideElement textNoteStarterElem = $(textNoteStarter).shouldBe(visible.because("Кнопка начала создания заметки не отображается!"));
        textNoteStarterElem.click();
        note.send();
        return this;
    }

    public ProfilePage openProfile() {
        $(userFullName).click();
        return new ProfilePage();
    }

    public LoginPage changeAvatar() {
        $(xPathAvatar).hover();
        $(changePhoto).click();
        $(privatePhoto).click();
        $(choosePhoto).click();
        $(agreeButton).click();
        $(cancelButton).click();
        exit();
        return new LoginPage();
    }

    public Class<? extends SelenideElement> getPhotoClass() {
        $(xPathAvatar).click();
        return $(xPathPhoto).getClass();
    }
}
