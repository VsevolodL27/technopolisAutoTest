package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.wrappers.FeedElementWrapper;
import pages.wrappers.NewNote;
import pages.wrappers.NewNoteBuilder;
import testdata.TestNoteData;
import utils.User;

import java.util.Optional;

import static com.codeborne.selenide.Selenide.refresh;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNote extends BaseTest {
    private static User user;
    private final String noteTestHeader = "Header";
    private final String noteTestText = "Test";

    @BeforeAll
    public static void init() {
        user = new User.UserBuilder()
                .setFullName(TestNoteData.username)
                .setLogin(TestNoteData.userLogin)
                .setPassword(TestNoteData.userPassword)
                .setId(TestNoteData.userId)
                .build();
    }

    @DisplayName("Note test")
    @Test
    public void noteTest() {
        String checkString = noteTestHeader + "\n" + noteTestText;

        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.authorization(user);

        NewNoteBuilder builder = NewNote.builder().addHeader(noteTestHeader).addText(noteTestText);
        mainPage.makeNote(builder.build());

        refresh();

        Optional<FeedElementWrapper> note = mainPage.getLastFeedByUsername(user.getName());
        assertEquals(checkString, note.get().getText(), "Text are different!");
    }

    @AfterEach
    public void end() {
        new MainPage().openNotePage().deleteLastNote();
    }
}
