import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public void authorization(User user) {
        String xPathLogin = "//*[@id=\"field_email\"]";
        $(By.xpath(xPathLogin)).setValue(user.getLogin());
        String xPathPassword = "//*[@id=\"field_password\"]";
        $(By.xpath(xPathPassword)).setValue(user.getPassword()).pressEnter();
    }
}
