package ChromeTest;

import Pages.LoginPageElements;
import Pages.MainPageElements;
import Pages.RegisterPageElements;
import com.UserOperations;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginTest {
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
    public void userCanLoginWithLoginInAccountButton() {
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        mainPage.clickLoginInAccountButton();
        LoginPageElements loginPage = page(LoginPageElements.class);
        loginPage.login(data.get("email"), data.get("password"));
        String actualText = mainPage.bunsSectionGetText();
        Assert.assertEquals("Не удалось войти в аккаунт", "Булки", actualText);
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void userCanLoginOnMainPage() {
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        mainPage.clickLoginButton();
        LoginPageElements loginPage = mainPage.login();
        loginPage.login(data.get("email"), data.get("password"));
        String actualText = mainPage.bunsSectionGetText();
        Assert.assertEquals("Не удалось войти в аккаунт", "Булки", actualText);

    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void userCanLoginWithLoginButtonInRegistrationForm() {
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        LoginPageElements loginPage = mainPage.login();
        RegisterPageElements registerPage = loginPage.register();
        mainPage.clickLoginButton();
        loginPage.linkToRegisterPageCheck();
        registerPage.clickRegistrationPageButtonLogin();
        loginPage.login(data.get("email"), data.get("password"));
        mainPage.clickLoginButton();
        String actualText = loginPage.profileLinkCheck();
        Assert.assertEquals("Не удалось войти в аккаунт", "Профиль", actualText);
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void userCanLoginWithLoginButtonInForgetPasswordForm() {
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        LoginPageElements loginPage = mainPage.login();
        mainPage.clickLoginInAccountButton();
        loginPage.clickLinkToForgetPasswordPage();
        loginPage.clickLinkToLoginPageFromForgetPasswordPage();
        loginPage.login(data.get("email"), data.get("password"));
        mainPage.clickLoginButton();
        String actualText = loginPage.profileLinkCheck();
        Assert.assertEquals("Не удалось войти в аккаунт", "Профиль", actualText);
    }
}
