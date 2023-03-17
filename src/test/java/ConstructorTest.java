import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;

import java.util.concurrent.TimeUnit;

public class ConstructorTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe"); //для запуска тестов в Яндекс браузере нужно раскомментировать эту строку
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Проверь, что работают переходы к разделам: «Булки» - Успешно")
    @Description("Checking if the button is selected by getting the text")
    public void menuBunIsActiveByClick() {
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFillingsButton();
        mainPage.clickBunsButton();
        Assert.assertEquals("Булки", mainPage.getTextFromSelectedMenu());
    }

    @Test
    @DisplayName("Проверь, что работают переходы к разделам: «Соусы» - Успешно")
    @Description("Checking if the button is selected by getting the text")
    public void menuSaucesIsActiveByClick() {
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFillingsButton();
        mainPage.clickSaucesButton();
        Assert.assertEquals("Соусы", mainPage.getTextFromSelectedMenu());
    }

    @Test
    @DisplayName("Проверь, что работают переходы к разделам: «Начинки» - Успешно")
    @Description("Checking if the button is selected by getting the text")
    public void menuFillingIsActiveByClick() {
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickSaucesButton();
        mainPage.clickFillingsButton();
        Assert.assertEquals("Начинки", mainPage.getTextFromSelectedMenu());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}