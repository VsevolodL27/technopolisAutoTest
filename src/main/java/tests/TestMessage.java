package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.LoginPage;
import pages.MainPage;
import pages.MessagePage;
import pages.wrappers.MessageWrapper;
import testdata.TestMessageData;
import utils.User;

import static com.codeborne.selenide.Selenide.$;

public class TestMessage extends BaseTest {
    private static User user1;
    private static User user2;

    @BeforeAll
    public static void init() {
        user1 = new User.UserBuilder()
                .setFullName(TestMessageData.username1)
                .setLogin(TestMessageData.userLogin1)
                .setPassword(TestMessageData.userPassword1)
                .setId(TestMessageData.userId1)
                .build();
        user2 = new User.UserBuilder()
                .setFullName(TestMessageData.username2)
                .setLogin(TestMessageData.userLogin2)
                .setPassword(TestMessageData.userPassword2)
                .setId(TestMessageData.userId2)
                .build();
    }

    @DisplayName("Message test")
    @ParameterizedTest
    @ValueSource(strings = {"Hi, how are you?", "What's happened?", "Goodbye!"})
    public void sendMessageTest(String message) {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.authorization(user1);

        MessagePage messagePage = mainPage.openMessage();
        $(messagePage.getXPathLineForSearch()).setValue(user2.getName());
        messagePage.openDialog(user2.getName()).sendMessage(message);

        loginPage = mainPage.exit();

        mainPage = loginPage.authorization(user2);
        messagePage = mainPage.openMessage();

        MessageWrapper messages = messagePage.openDialog(user2.getName()).getLastReceivedMessage();
        Assertions.assertEquals(messages.getMessageText(), message, "Messages are different!");
    }

    @AfterEach
    public void end() {
        new MessagePage().getLastReceivedMessage().deleteMessage();
    }
}
