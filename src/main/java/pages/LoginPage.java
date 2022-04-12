package pages;

import com.codeborne.selenide.Condition;
import locators.LoginPageLocators;
import utils.User;

public class LoginPage extends BasePage {

    public LoginPage() {
        isLoaded();
    }

    @Override
    public void isLoaded() {
        LoginPageLocators.xPathLogin.shouldBe(Condition.visible.because("Login field not found"));
        LoginPageLocators.xPathPassword.shouldBe(Condition.visible.because("Password field not found"));
    }

    public MainPage authorization(User user) {
        LoginPageLocators.xPathLogin.setValue(user.getLogin());
        LoginPageLocators.xPathPassword.setValue(user.getPassword()).pressEnter();
        return new MainPage();
    }
}
