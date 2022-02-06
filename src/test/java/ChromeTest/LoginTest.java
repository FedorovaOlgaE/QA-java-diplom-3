package ChromeTest;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
import com.model.LoginPageElements;
import com.model.MainPageElements;
import com.model.RegisterPageElements;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

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
        LoginPageElements loginPage = mainPage.login();
        mainPage.loginInAccountButton.click();
        loginPage.login(data.get("email"), data.get("password"));
        mainPage.loginButton.click();
        Assert.assertEquals(loginPage.accountUserNameInput.getValue(), data.get("name"));
    }
    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void userCanLoginOnMainPage(){
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        LoginPageElements loginPage = mainPage.login();
        mainPage.loginButton.click();
        loginPage.login(data.get("email"), data.get("password"));
        mainPage.loginButton.click();
        Assert.assertEquals(loginPage.accountUserNameInput.getValue(), data.get("name"));

    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void userCanLoginWithLoginButtonInRegistrationForm(){
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        LoginPageElements loginPage = mainPage.login();
        RegisterPageElements registerPage = loginPage.register();
        mainPage.loginButton.click();
        loginPage.linkToRegisterPage.click();
        registerPage.linkToLoginPage.click();
        loginPage.login(data.get("email"), data.get("password"));
        mainPage.loginButton.click();
        Assert.assertEquals(loginPage.accountUserNameInput.getValue(), data.get("name"));
    }
    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void userCanLoginWithLoginButtonInForgetPasswordForm(){
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        LoginPageElements loginPage = mainPage.login();
        mainPage.loginInAccountButton.click();
        loginPage.linkToForgetPasswordPage.click();
        loginPage.linkToLoginPageFromForgetPasswordPage.click();
        loginPage.login(data.get("email"), data.get("password"));
        mainPage.loginButton.click();
        Assert.assertEquals(loginPage.accountUserNameInput.getValue(), data.get("name"));
    }
}
