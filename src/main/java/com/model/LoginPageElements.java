package com.model;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class LoginPageElements {
    //поле email
    @FindBy(xpath = "//input[@class='text input__textfield text_type_main-default' and @name='name']")
    public SelenideElement loginPageEmail;
    //поле пароль
    @FindBy(xpath = "//input[@class='text input__textfield text_type_main-default' and @name='Пароль']")
    public SelenideElement loginPagePassword;
    //кнопка войти
    @FindBy(xpath = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()='Войти']")
    public SelenideElement loginPageButton;
    //ссылка на регистрацию
    @FindBy(xpath = "//a[@href='/register']")
    public SelenideElement linkToRegisterPage;
    //ссылка на забыли пароль
    @FindBy(xpath = "//a[@href='/forgot-password']")
    public SelenideElement linkToForgetPasswordPage;
    //ссылка  на логин со страницы восстановления пароля
    @FindBy(xpath = "//a[@href='/login']")
    public SelenideElement linkToLoginPageFromForgetPasswordPage;
    // Кнопка выхода из аккаунта
    @FindBy(xpath = "//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']")
    public SelenideElement accountLogoutButton;
    // Поле с именем рользователя заполнено
    @FindBy(xpath = "//input[@class='text input__textfield text_type_main-default input__textfield-disabled' and @name='Name']")
    public SelenideElement accountUserNameInput;

    //форма заполнена
    public void login(String email, String password) {
        loginPageEmail.setValue(email);
        loginPagePassword.setValue(password);
        loginPageButton.click();
    }
    // Переход на страницу регистрации
    public RegisterPageElements register() {
        return page(RegisterPageElements.class);
    }
}
