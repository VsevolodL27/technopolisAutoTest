package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.PhotoPage;
import pages.ProfilePage;
import testdata.TestAlbumData;
import testdata.TestPhotoData;
import utils.User;

import java.io.File;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPhoto extends BaseTest {
    private static User user;
    private final Path photoPath = new File(TestPhotoData.file).getAbsoluteFile().toPath();

    @BeforeAll
    public static void init() {
        user = new User.UserBuilder()
                .setFullName(TestAlbumData.username)
                .setLogin(TestAlbumData.userLogin)
                .setPassword(TestAlbumData.userPassword)
                .setId(TestAlbumData.userId)
                .build();
    }

    @DisplayName("Add photo test")
    @Test
    public void albumTest() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.authorization(user);

        ProfilePage profilePage = mainPage.openProfile();
        PhotoPage photoPage = profilePage.openPhotoPage();

        photoPage.addPhoto(photoPath.toString());

        assertTrue(photoPage.checkAddingPhoto(), "Photo not found!");
    }
}
