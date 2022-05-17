package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.LoginPage;
import pages.MainPage;
import pages.wrappers.FeedElementWrapper;
import testdata.TestEmojiData;
import utils.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEmoji extends BaseTest {
    private static User user;

    @BeforeAll
    public static void init() {
        user = new User.UserBuilder()
                .setFullName(TestEmojiData.username)
                .setLogin(TestEmojiData.userLogin)
                .setPassword(TestEmojiData.userPassword)
                .setId(TestEmojiData.userId)
                .build();
    }

    @DisplayName("Emoji test")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    public void reactionTest(int numOfReaction) {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.authorization(user);

        FeedElementWrapper post = mainPage.getFeedList().get(0);
        String selectedReactionName = post.setReaction(numOfReaction);

        assertEquals(selectedReactionName, post.getReactionName(), "Reactions are different");
    }
}
