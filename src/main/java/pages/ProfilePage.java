package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage extends BasePage {
    private final By shareProfile = By.xpath("//span[contains(text(), 'Поделиться профилем')]");
    private final By photoPage = By.xpath("//a[contains(@data-l, 't,userPhotos')]");

    @Override
    public void isLoaded() {
        $(shareProfile).shouldBe(visible.because("Profile page didn't load"));
    }

    public PhotoPage openPhotoPage() {
        $(photoPage).click();
        return new PhotoPage();
    }
}
