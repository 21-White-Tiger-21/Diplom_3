import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.*;
import pages.*;
import steps.UserClient;
import static org.junit.Assert.assertTrue;
import static config.Init.setSettings;

public class TestRegisterNewUser {
    private UserClient userClient;
    private UserCredentialsModel creds;
    private UserModel userModel;
    boolean afterToBeLaunched;
    @Before
    public void setUp() {
        setSettings();
        Selenide.open("/");
        userClient = new UserClient();
        userModel = UserModel.getRandom();
        creds = UserCredentialsModel.from(userModel);
    }
    @After
    public void teardown() {
        WebDriverRunner.closeWebDriver();
        if (!afterToBeLaunched) {
            return;
        }
        String bearerToken = userClient.login(creds)
                .then().log().all()
                .extract()
                .path("accessToken");
        userClient.delete(userModel.getEmail(), bearerToken);
    }
    @Test
    @DisplayName("Проверь: Успешную регистрацию. Минимальный пароль — шесть символов - Успешно")
    public void registerNewUserWithCorrectPassSuccessfully() {
        userModel.setPassword("Tank11");
        final boolean correctPasswordWarningDisplayed = new MainPage()
                .clickLoginButton()
                .clickRegisterLink()
                .registerNewUser(userModel)
                .isUserLoginTextDisplayed();
        assertTrue(correctPasswordWarningDisplayed);
    }
    @Test
    @DisplayName("Проверь: Ошибку для некорректного пароля. Минимальный пароль — шесть символов -  НЕ Успешно")
    public void registerNewUserWithIncorrectPassFails() {
        userModel.setPassword("Tank1");
        final boolean incorrectPasswordWarningDisplayed = new MainPage()
                .clickLoginButton()
                .clickRegisterLink()
                .registerNewUserWithIncorrectPass(userModel)
                .isIncorrectPassDisplayed();
        assertTrue(incorrectPasswordWarningDisplayed);
    }
}