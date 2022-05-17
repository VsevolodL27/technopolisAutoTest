package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;
import testdata.TestAlbumData;
import utils.User;

import java.io.File;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAlbum extends BaseTest {
    private static User user;
    private final Path photoAvatarPath =
            new File("C:/Users/lavre/Downloads/file1.jpeg").getAbsoluteFile().toPath();

    @BeforeAll
    public static void init() {
        user = new User.UserBuilder()
                .setFullName(TestAlbumData.username)
                .setLogin(TestAlbumData.userLogin)
                .setPassword(TestAlbumData.userPassword)
                .setId(TestAlbumData.userId)
                .build();
    }

    @DisplayName("Create album test")
    @Test
    public void albumTest() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.authorization(user);

        ProfilePage profilePage = mainPage.openProfile();
        PhotoPage photoPage = profilePage.openPhotoPage();

        AlbumPage albumPage = photoPage.createAlbum();

        assertEquals(TestAlbumData.albumName, albumPage.checkCreateAlbum(), "Album not found!");
    }
}
