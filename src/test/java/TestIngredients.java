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
    private final MainPage mainPage = new MainPage();
    @Before
    public void setUp() {
        setSettings();
        Selenide.open("/");
    }
    @After
    public void teardown() {
        WebDriverRunner.closeWebDriver();
    }
    @Test
    @DisplayName("Проверить, что работают переходы к разделам: «Булки» - Успешно")
    public void checkBunsTabGetsActivatedSuccessfully() {
        String actual = mainPage.getBunsTabClassValue();
        assertEquals("Булки", actual);
    }
    @Test
    @DisplayName("Проверить, что работают переходы к разделам: «Соусы» - Успешно")
    public void checkSaucesTabGetsActivatedSuccessfully() {
        String actual = mainPage.getSaucesTabClassValue();
        assertEquals("Соусы", actual);
    }
    @Test
    @DisplayName("Проверить, что работают переходы к разделам: «Начинки» - Успешно")
    public void checkFillingsTabGetsActivatedSuccessfully() {
        String actual = mainPage.getFillingsTabClassValue();
        assertEquals("Начинки", actual);
    }
}