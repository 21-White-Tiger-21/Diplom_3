package config;

import com.codeborne.selenide.Configuration;
public class Init {
    public static final String PATH_DRIVER_YANDEX = "src/main/resources/driver/yandexdriver.exe";
    /**
     * метод которым можно выбрать активный браузер
     **/
    public static void setSettings() {
        Configuration.baseUrl = "https://stellarburgers.nomoreparties.site";
        Configuration.holdBrowserOpen = false;
        Configuration.browser = "chrome";                                   //для запуска браузера Chrome раскомментировать 18 строку
           // System.setProperty("webdriver.chrome.driver", PATH_DRIVER_YANDEX);  //для запуск браузера Yandex раскомментировать 19 и 20 строку
           // WebDriverRunner.setWebDriver(new ChromeDriver());
    }
}