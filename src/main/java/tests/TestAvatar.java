package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import testdata.TestAvatarData;
import utils.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAvatar extends BaseTest {
    private static User user;
    private final String photo = "class jdk.proxy2.$Proxy17";

    @BeforeAll
    public static void init() {
        user = new User.UserBuilder()
                .setFullName(TestAvatarData.username)
                .setLogin(TestAvatarData.userLogin)
                .setPassword(TestAvatarData.userPassword)
                .setId(TestAvatarData.userId)
                .build();
    }

    @DisplayName("Change avatar")
    @Test
    public void avatarTest() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.authorization(user);

        mainPage.changeAvatar();
        loginPage.authorization(user);

        assertEquals(mainPage.getPhotoClass().toString(), photo, "Avatar has not changed");
    }
}
