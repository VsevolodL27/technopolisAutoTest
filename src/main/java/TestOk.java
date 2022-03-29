import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class TestOk {

    @org.junit.Test
    public void test() {
        open("https://ok.ru");
        User user = new User("Alexandr Nevsky", "Alex13051221", "LedovoePoboishe1942");
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        loginPage.authorization(user);
        try {
            assertEquals(mainPage.getFullName(), user.getFullName());
        } catch (Exception e) {
            System.out.println("Incorrect username and/or password");
        }
    }
}
