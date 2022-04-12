package tests;

import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.MessagePage;
import pages.wrappers.MessageWrapper;
import testdata.TestMessageData;
import utils.User;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class TestMessage {
    @Test
    public void testMessage(){
        open("https://ok.ru");
        try {
            User user1 = new User.UserBuilder()
                    .setFullName(TestMessageData.username1)
                    .setLogin(TestMessageData.userLogin1)
                    .setPassword(TestMessageData.userPassword1)
                    .setId(TestMessageData.userId1)
                    .build();

            User user2 = new User.UserBuilder()
                    .setFullName(TestMessageData.username2)
                    .setLogin(TestMessageData.userLogin2)
                    .setPassword(TestMessageData.userPassword2)
                    .setId(TestMessageData.userId2)
                    .build();

            String text = "Привет, как дела?";
            LoginPage loginPage = new LoginPage();
            MainPage mainPage = loginPage.authorization(user1);

            MessagePage messagePage = mainPage.openMessage();
            messagePage.openDialog(user2.getId()).sendMessage(text);

            loginPage = mainPage.exit();

            mainPage = loginPage.authorization(user2);
            messagePage = mainPage.openMessage();

            MessageWrapper message = messagePage.openDialog(user1.getId()).getLastReceivedMessage();
            assertEquals(message.getMessageText(), text);
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            closeWindow();
        }
    }
}
