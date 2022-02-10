package com.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPageElements {
    //поле email
    @FindBy(xpath = "//input[@class='text input__textfield text_type_main-default' and @name='name']")
    private SelenideElement loginPageEmail;
    //поле пароль
    @FindBy(xpath = "//input[@class='text input__textfield text_type_main-default' and @name='Пароль']")
    private SelenideElement loginPagePassword;
    //кнопка войти
    @FindBy(xpath = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()='Войти']")
    private SelenideElement loginPageButton;
    //ссылка на регистрацию
    @FindBy(xpath = "//a[@href='/register']")
    private SelenideElement linkToRegisterPage;

    //ссылка на забыли пароль
    @FindBy(xpath = "//a[@href='/forgot-password']")
    private SelenideElement linkToForgetPasswordPage;

    //ссылка на логин со страницы восстановления пароля
    @FindBy(xpath = "//a[@href='/login']")
    private SelenideElement linkToLoginPageFromForgetPasswordPage;

    // Кнопка выхода из аккаунта
    @FindBy(xpath = "//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']")
    private SelenideElement accountLogoutButton;

    // Ссылка Профиль
    @FindBy(how = How.CLASS_NAME, using = "Account_link__2ETsJ")
    private SelenideElement profileLink;

    @Step("Пользователь заполняет поле email")
    public void setEmail(String email) {
        loginPageEmail.setValue(email);
    }

    @Step("Пользователь заполняет поле пароль")
    public void setPassword(String password) {
        loginPagePassword.setValue(password);
    }

    @Step("Пользователь кликает на кнопку Войти")
    public void clickLoginPageButton() {
        loginPageButton.click();
    }

    @Step("Пользователь заполнил форму")
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginPageButton();

    }

    @Step("Пользователь перешел на страницу регистрации")
    public RegisterPageElements register() {
        return Selenide.page(RegisterPageElements.class);
    }

    @Step("Пользователь кликает на ссылку регистрации")
    public void linkToRegisterPageCheck() {
        linkToRegisterPage.click();
    }

    @Step("Пользователь кликает на ссылку Забыли пароль")
    public void clickLinkToForgetPasswordPage() {
        linkToForgetPasswordPage.click();
    }

    @Step("Пользователь кликает на ссылку Входа со страницы Забыли пароль")
    public void clickLinkToLoginPageFromForgetPasswordPage() {
        linkToLoginPageFromForgetPasswordPage.click();
    }

    @Step("Пользователь кликает по кнопке выхода из аккаунта")
    public void clickAccountLogoutButton() {
        accountLogoutButton.click();
    }

    @Step("Получение текста кнопки Войти")
    public String loginPageButtonGetText() {
        return loginPageButton.getText();
    }

    @Step("Проверка текста Профиль")
    public String profileLinkCheck() {
        return profileLink.getText();
    }

}
