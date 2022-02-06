package ChromeTest;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
import com.model.LoginPageElements;
import com.model.MainPageElements;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class LogoutTest {
    private UserOperations userOperations;
    private Map<String, String> data;

    @Before
    public void beforeTest() {
        Configuration.browser = "chrome";
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
        mainPage.loginInAccountButton.click();
        loginPage.login(data.get("email"), data.get("password"));
        mainPage.loginButton.click();
        loginPage.accountLogoutButton.click();
        Assert.assertEquals(loginPage.loginPageButton.getText(), "Войти");
    }
}
