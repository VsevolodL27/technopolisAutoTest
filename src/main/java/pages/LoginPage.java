package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import utils.User;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class LoginPage extends BasePage {

    private final By xPathLogin = By.xpath("//*[@id=\"field_email\"]");
    private final By xPathPassword = By.xpath("//*[@id=\"field_password\"]");
    private final By xPathGoogleIcon = By.xpath("//div[contains(@class, 'social-icon __s __gp')]");
    private final By xPathGoogleLogin = By.xpath("//input[contains(@type, 'email')]");
    private final By xPathGooglePassword = By.xpath("//input[contains(@type, 'password')]");

    @Override
    public void isLoaded() {
        $(xPathLogin).shouldBe(Condition.exist.because("Login field not found"));
        $(xPathPassword).shouldBe(Condition.visible.because("Password field not found"));
    }

    public MainPage authorization(User user) {
        $(xPathLogin).setValue(user.getLogin());
        $(xPathPassword).setValue(user.getPassword()).pressEnter();
        return new MainPage();
    }

    public MainPage loginGoogleAccount(User user) {
        $(xPathGoogleIcon).click();
        switchTo().window(1);
        $(xPathGoogleLogin).setValue(user.getGoogleLogin()).pressEnter();
        $(xPathGooglePassword).setValue(user.getGooglePassword()).pressEnter();
        return new MainPage();
    }
}
