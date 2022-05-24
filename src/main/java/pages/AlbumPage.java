package pages;

import org.openqa.selenium.By;
import testdata.TestAlbumData;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AlbumPage extends BasePage {
    private final By loadButton = By.xpath("//input[contains(@type,'file')]");
    private final By correctCreateAlbum = By.xpath("//input[contains(@type,'file')]");
    private final By searchField = By.xpath("//input[contains(@id, 'field_query')]");
    private final By xPathAlbum = By.xpath("//a[contains(text(), 'Test album')]");

    @Override
    public void isLoaded() {
        $(loadButton).shouldBe(visible.because("Album page didn't load"));
    }

    public AlbumPage addPhoto(String path) {
        $(loadButton).sendKeys(path);
        return this;
    }

    public String checkCreateAlbum() {
        $(searchField).setValue(TestAlbumData.albumName).pressEnter();
        return $(xPathAlbum).getText();
    }
}
