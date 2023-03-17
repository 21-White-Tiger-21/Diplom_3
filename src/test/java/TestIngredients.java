import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;
import static config.Init.setSettings;
import static org.junit.Assert.assertEquals;

public class TestIngredients {
    private MainPage mainPage;
    @Before
    public void setUp() {
        setSettings();
        Selenide.open("/");
        mainPage = new MainPage();
    }
    @After
    public void teardown() {
        WebDriverRunner.closeWebDriver();
    }
    @Test
    @DisplayName("Проверка, текста ссылок: «Булки» - Успешно")
    public void checkBunsTabGetsActivatedSuccessfully() {
        String actual = mainPage.getBunsTabClassValue();
        mainPage.displayAvailableFillings();
        mainPage.displayAvailableBuns();
        assertEquals("Булки", actual);
    }
    @Test
    @DisplayName("Проверка, текста ссылок: «Соусы» - Успешно")
    public void checkSaucesTabGetsActivatedSuccessfully() {
        String actual = mainPage.getSaucesTabClassValue();
        mainPage.displayAvailableFillings();
        mainPage.displayAvailableSauces();
        assertEquals("Соусы", actual);
    }
    @Test
    @DisplayName("Проверка, текста ссылок: «Начинки» - Успешно")
    public void checkFillingsTabGetsActivatedSuccessfully() {
        String actual = mainPage.getFillingsTabClassValue();
        mainPage.displayAvailableSauces();
        mainPage.displayAvailableFillings();
        assertEquals("Начинки", actual);
    }
}