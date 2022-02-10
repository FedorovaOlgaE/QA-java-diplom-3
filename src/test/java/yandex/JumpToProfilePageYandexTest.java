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

public class JumpToProfilePageYandexTest {
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
    @DisplayName("переход по клику на «Личный кабинет»")
    public void userCanLoginOnMainPage() {
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        LoginPageElements loginPage = mainPage.login();
        mainPage.clickLoginButton();
        loginPage.login(data.get("email"), data.get("password"));
        mainPage.clickLoginButton();
        String actualText = loginPage.profileLinkCheck();
        Assert.assertEquals("Не удалось войти в аккаунт", "Профиль", actualText);

    }
}
