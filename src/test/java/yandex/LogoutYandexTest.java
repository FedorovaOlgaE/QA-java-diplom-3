package yandex;

import com.pages.LoginPageElements;
import com.pages.MainPageElements;
import com.UserOperations;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class LogoutYandexTest {
    private UserOperations userOperations;
    private Map<String, String> data;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
        Configuration.startMaximized = true;
        userOperations = new UserOperations();
        data = userOperations.register();
    }

    @After
    public void afterTest() {
        userOperations.delete();
    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void userCanLogout() {
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        LoginPageElements loginPage = mainPage.login();
        mainPage.clickLoginInAccountButton();
        loginPage.login(data.get("email"), data.get("password"));
        mainPage.clickLoginButton();
        loginPage.clickAccountLogoutButton();
        String actualText = loginPage.loginPageButtonGetText();
        Assert.assertEquals("Не удалось выйти из профиля", "Войти", actualText);
    }
}
