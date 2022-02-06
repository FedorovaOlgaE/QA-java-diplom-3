package ChromeTest;

import com.codeborne.selenide.Configuration;
import com.model.MainPageElements;
import com.model.LoginPageElements;
import com.model.RegisterPageElements;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest {
    private String email;
    private String password;
    private String name;
    private String incorrectPass;

    @Before
    public void beforeTest() {
        Configuration.browser = "chrome";
        Configuration.startMaximized=true;
        email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        password = RandomStringUtils.randomAlphabetic(10);
        name = RandomStringUtils.randomAlphabetic(10);
        incorrectPass = RandomStringUtils.randomAlphabetic(5);
    }
    @Test
    @DisplayName("Успешная регистрация")
    public void correctRegistrationTest(){
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        LoginPageElements loginPage = mainPage.login();
        RegisterPageElements registerPage = loginPage.register();
        mainPage.loginButton.click();
        loginPage.linkToRegisterPage.click();
        registerPage.registrationFormFilled(name, email, password);
        registerPage.registrationPageButton.click();

    }
    @Test
    @DisplayName("Не успешная регистрация. Ошибка для некорректного пароля")
    public void incorrectRegistrationTest(){
        MainPageElements mainPage = open("https://stellarburgers.nomoreparties.site/", MainPageElements.class);
        LoginPageElements loginPage = mainPage.login();
        RegisterPageElements registerPage = loginPage.register();
        mainPage.loginButton.click();
        loginPage.linkToRegisterPage.click();
        registerPage.registrationFormFilled(name, email, incorrectPass);
        registerPage.registrationPageButton.click();
        Assert.assertEquals(registerPage.incorrectPasswordWarn.getText(), "Некорректный пароль");
    }

}
