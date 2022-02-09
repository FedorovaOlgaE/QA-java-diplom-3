package YandexTests;

import Pages.LoginPageElements;
import Pages.MainPageElements;
import Pages.RegisterPageElements;
import com.UserOperations;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationYandexTest {
    private String email;
    private String password;
    private String name;
    private String incorrectPass;
    private UserOperations userOperations;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
        Configuration.startMaximized = true;
        email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        password = RandomStringUtils.randomAlphabetic(10);
        name = RandomStringUtils.randomAlphabetic(10);
        incorrectPass = RandomStringUtils.randomAlphabetic(5);
        userOperations = new UserOperations();
    }


    @Test
    @DisplayName("Успешная регистрация")
    public void correctRegistrationTest() {
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        LoginPageElements loginPage = mainPage.login();
        RegisterPageElements registerPage = loginPage.register();
        mainPage.clickLoginButton();
        loginPage.linkToRegisterPageCheck();
        registerPage.registrationFormFilled(name, email, password);

    }

    @Test
    @DisplayName("Не успешная регистрация. Ошибка для некорректного пароля")
    public void incorrectRegistrationTest() {
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        LoginPageElements loginPage = mainPage.login();
        RegisterPageElements registerPage = loginPage.register();
        mainPage.clickLoginButton();
        loginPage.linkToRegisterPageCheck();
        registerPage.registrationFormFilled(name, email, incorrectPass);
        String actualText = registerPage.getRegisterErrorText();
        Assert.assertEquals("Текст ошибки не совпадает", "Некорректный пароль", actualText);
    }
}
