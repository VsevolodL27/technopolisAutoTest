package tests;

import testdata.TestMessageData;
import testdata.TestOkData;
import org.junit.Assert;
import pages.LoginPage;
import pages.MainPage;
import utils.User;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class TestOk {

    @org.junit.Test
    public void test() {
        open("https://ok.ru");
        User user = new User.UserBuilder()
                .setFullName(TestOkData.username)
                .setLogin(TestOkData.userLogin)
                .setPassword(TestOkData.userPassword)
                .setId(TestOkData.userId)
                .build();
        LoginPage loginPage = new LoginPage();
        loginPage.authorization(user);
        try {
            MainPage mainPage = loginPage.authorization(user);
            assertEquals(mainPage.getFullName(),user.getName());
        } catch (Exception e) {
            System.out.println("Incorrect username and/or password");
        } finally {
            closeWindow();
        }
    }
}
