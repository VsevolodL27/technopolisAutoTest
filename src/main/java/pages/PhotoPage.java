package pages;

import org.openqa.selenium.By;
import testdata.TestAlbumData;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PhotoPage extends BasePage {
    private final By albumSearch = By.xpath("//div[contains(@class, 'it_w search-input')]");
    private final By crateAlbum = By.xpath("//a[contains(@data-l, 't,create-photo-album')]");
    private final By albumNameField = By.xpath("//textarea[contains(@name, 'st.layer.photoAlbumName')]");
    private final By createButton = By.xpath("//input[contains(@name, 'button_album_create')]");
    private final By loadPhotoButton = By.cssSelector("div#hook_Block_PhotoVitrineBlock div input[type=file]");
    private final By correctDownloadMessage = By.xpath("//*[contains(@data-l,\"t,create-post\")]");

    @Override
    public void isLoaded() {
        $(albumSearch).shouldBe(visible.because("Photo page didn't load"));
    }

    public AlbumPage createAlbum() {
        $(crateAlbum).click();
        $(albumNameField).setValue(TestAlbumData.albumName);
        $(createButton).click();
        return new AlbumPage();
    }

    public PhotoPage addPhoto(String path) {
        $(loadPhotoButton).sendKeys(path);
        return this;
    }

    public boolean checkAddingPhoto() {
        return $(correctDownloadMessage).isDisplayed();
    }
}
