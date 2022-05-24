package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    @BeforeEach
    public void openWindow() {
        String urlOK = "https://ok.ru";
        open(urlOK);
    }

    @AfterEach
    public void closeWindow() {
        Selenide.closeWindow();
    }
}
