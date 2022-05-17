package tests;

import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.MainPage;
import testdata.TestLoginData;
import utils.User;

public class TestLogin extends BaseTest {
    private static User user;

    @BeforeAll
    public static void init() {
        user = new User.UserBuilder()
                .setFullName(TestLoginData.username)
                .setLogin(TestLoginData.userLogin)
                .setPassword(TestLoginData.userPassword)
                .setId(TestLoginData.userId)
                .build();
    }

    @DisplayName("Login test for ok.ru")
    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.authorization(user);
        Assertions.assertTrue(user.getName().equals(mainPage.getFullName()), "Login attempt failed!");
    }

    @Disabled
    @DisplayName("Login test for ok.ru with Google Account")
    @Test
    public void loginTestGoogleAccount() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.loginGoogleAccount(user);
        Assertions.assertTrue(user.getName().equals(mainPage.getFullName()), "Login attempt failed!");
    }
}
