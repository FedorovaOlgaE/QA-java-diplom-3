package ChromeTest;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
import com.model.LoginPageElements;
import com.model.MainPageElements;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class JumpFromProfilePageTest {
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
    @DisplayName("переход на главную страницу по клику на «Конструктор»")
    public void jumpFromProfileToMainPageByConstructorButtonTest(){
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        LoginPageElements loginPage = mainPage.login();
        mainPage.loginInAccountButton.click();
        loginPage.login(data.get("email"), data.get("password"));
        mainPage.loginButton.click();
        mainPage.constructorMenuButton.click();
    }
    @Test
    @DisplayName("переход на главную по клику на лого")
    public void jumpFromProfileToMainPageByLogoTest(){
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        LoginPageElements loginPage = mainPage.login();
        mainPage.loginInAccountButton.click();
        loginPage.login(data.get("email"), data.get("password"));
        mainPage.loginButton.click();
        mainPage.logo.click();
    }
}
