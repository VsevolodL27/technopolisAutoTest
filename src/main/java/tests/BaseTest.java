package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    private final String urlOK = "https://ok.ru";

//    @BeforeAll
//    public abstract void init();

    @BeforeEach
    public void openWindow() {
        open(urlOK);
    }

    @AfterEach
    public void closeWindow() {
        Selenide.closeWindow();
    }
}
